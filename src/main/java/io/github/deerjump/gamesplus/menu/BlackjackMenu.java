package io.github.deerjump.gamesplus.menu;

import io.github.deerjump.builders.ItemBuilder;
import io.github.deerjump.builders.SkullBuilder;
import io.github.deerjump.gamesplus.GamesPlus;
import io.github.deerjump.gamesplus.games.blackjack.Blackjack;
import io.github.deerjump.gamesplus.games.cards.Card;
import io.github.deerjump.menuapi.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import java.util.Iterator;

import static io.github.deerjump.gamesplus.textures.Heads.DEALER;
import static org.bukkit.ChatColor.GRAY;
import static org.bukkit.ChatColor.GREEN;
import static org.bukkit.ChatColor.RED;
import static org.bukkit.ChatColor.WHITE;
import static org.bukkit.Material.BARRIER;
import static org.bukkit.Material.GREEN_WOOL;
import static org.bukkit.Material.RED_STAINED_GLASS_PANE;
import static org.bukkit.Material.RED_WOOL;

public class BlackjackMenu extends Menu {
    private final static String MENU_TITLE = "Blackjack";
    private final Blackjack game;
    private Player player;

    public BlackjackMenu() {
        super(54, MENU_TITLE);
        System.out.println("Starting Blackjack Game!");
        game = new Blackjack();
    }

    @Override
    public boolean onClick(Player player, int slot, ClickType type) {
        if (type == ClickType.DOUBLE_CLICK) return true;

        switch (slot) {
            case 38: { game.hit(); break; }
            case 39: { game.stay(); playWithoutPlayer(); break; }
            case 49: { player.openInventory(new GamesMenu().getInventory()); break; }
            default: return true;
        }

        update();

        return true;
    }

    private void update() {
        showCards();
        handleWinner();
    }

    private void playWithoutPlayer() {
        GamesPlus.runTaskTimer(task -> {
            if (this.getInventory().getViewers().isEmpty()) {
                task.cancel();
                return;
            }
            game.stay();
            update();
        }, 20, 20);
    }

    private void showCards() {
        Iterator<Card> playerIterator = game.getPlayerHand().iterator();
        Iterator<Card> dealerIterator = game.getDealerHand().iterator();

        for (int i = 10; i < 30; i += 9) {
            for (int j = 0; j < 3; j++) {
                // show player's cards
                if (playerIterator.hasNext())
                    inventory.setItem(i + j, playerIterator.next().getItem());
                // show dealer's cards
                if (dealerIterator.hasNext())
                    inventory.setItem(i + j + 4, dealerIterator.next().getItem());
            }
        }
    }

    @Override
    public void onOpen(Player player) {
        if (game.isStarted()) return;
        this.player = player;

        showCards();
        inventory.setItem(37, new SkullBuilder(player.getName()).name("Your Score").amount(game.getPlayerScore()).build());
        inventory.setItem(38, new ItemBuilder(GREEN_WOOL).name("Hit me!").build());
        inventory.setItem(39, new ItemBuilder(RED_WOOL).name("Stay.").build());
        inventory.setItem(43, new SkullBuilder().setUrl(DEALER).name("Dealer Score").amount(game.getDealerScore()).build());
        inventory.setItem(49, new ItemBuilder(BARRIER).name("Quit?").build());

        fill(new ItemBuilder(RED_STAINED_GLASS_PANE).name(" ").build());

        GamesPlus.runTaskLater(task -> update(), 20);
        game.setStarted(true);
    }

    private void handleWinner() {
        int playerScore = game.getPlayerScore();
        int dealerScore = game.getDealerScore();

        switch (game.getWinner()) {
            case PLAYER: {
                player.closeInventory();
                player.sendMessage(String.format("%sYou win!%s\nYour score: %s\nDealer's score: %s ", GREEN, WHITE, playerScore, dealerScore));
                break;
            }
            case DEALER: {
                player.closeInventory();
                player.sendMessage(String.format("%sYou lose!%s\nYour score: %s\nDealer's score: %s", RED, WHITE, playerScore, dealerScore));
                break;
            }
            case DRAW: {
                player.closeInventory();
                player.sendMessage(String.format("The game ended in a %sdraw%s!\nThe score was: %s", GRAY, WHITE, playerScore));
            }
            case NONE: {
                inventory.setItem(37, new SkullBuilder(player.getName()).name("Your score").amount(playerScore).build());
                inventory.setItem(43, new SkullBuilder().setUrl(DEALER).name("Dealer score").amount(dealerScore).build());
                break;
            }
        }
    }

    @Override
    public void onClose(Player player) {

    }

    @Override
    protected void fill(ItemStack item) {
        // fill in top row
        for (int i = 0; i < 9; i++) {
            if (inventory.getItem(i) != null ) continue;
            inventory.setItem(i, item);
        }

        // fill in side columns
        for (int i = 9; i < inventory.getSize(); i += 9) {
            if (inventory.getItem(i) != null ) continue;
            inventory.setItem(i, item);
            inventory.setItem(i + 4, item);
            inventory.setItem(i + 8, item);
        }

        // fill in bottom row
        for (int i = 46; i < inventory.getSize(); i++) {
            if (inventory.getItem(i) != null ) continue;
            inventory.setItem(i, item);
        }
    }
}
