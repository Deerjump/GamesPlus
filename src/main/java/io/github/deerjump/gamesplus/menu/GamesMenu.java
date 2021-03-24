package io.github.deerjump.gamesplus.menu;

import io.github.deerjump.builders.BannerBuilder;
import io.github.deerjump.builders.ItemBuilder;
import io.github.deerjump.menuapi.Menu;
import org.bukkit.DyeColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import static io.github.deerjump.gamesplus.games.cards.BannerLetters.*;
import static org.bukkit.ChatColor.*;
import static org.bukkit.Material.*;


public class GamesMenu extends Menu {
    private final static String MENU_TITLE = BLUE + "Do you want to play a game?!";

    public GamesMenu() {
        super(54, MENU_TITLE);
    }

    @Override
    public boolean onClick(Player player, int slot, ClickType type) {
        if (type == ClickType.DOUBLE_CLICK) return true;

        switch(slot) {
            case 38: { player.sendMessage(GREEN + "Well, lets play then!"); player.openInventory(new BlackjackMenu().getInventory()); break; }
            case 42: { player.sendMessage(RED + "Aww, too bad..."); player.closeInventory(); break; }
            default: break;
        }

        return true;
    }

    @Override
    public void onOpen(Player player) {
        inventory.setItem(20, new BannerBuilder(WHITE_BANNER).name(GRAY + "Blackjack").addPatterns(JACK(DyeColor.BLACK)).build());
        inventory.setItem(38, new ItemBuilder(GREEN_STAINED_GLASS_PANE).name(GREEN + "Yeah, let's play!").build());
        inventory.setItem(42, new ItemBuilder(RED_STAINED_GLASS_PANE).name(RED +  "Quit?").build());

        fill(new ItemBuilder(BLACK_STAINED_GLASS_PANE).name(" ").build());
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

        // fill in middle and side columns
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
