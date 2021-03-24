package io.github.deerjump.gamesplus.menu;

import io.github.deerjump.gamesplus.games.cards.Card;
import io.github.deerjump.gamesplus.games.cards.Deck;
import io.github.deerjump.menuapi.Menu;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import java.util.List;


public class CardsMenu extends Menu {

    private static final String MENU_TITLE = "Cards Menu";
    private final Deck deck;

    public CardsMenu() {
        super(54, MENU_TITLE);
        deck = new Deck();
    }

    @Override
    public boolean onClick(Player player, int slot, ClickType type) {
        return true;
    }

    @Override
    public void onOpen(Player player) {
        List<Card> cards = deck.getCards();
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            inventory.setItem(i, card.getItem());
        }
    }

    @Override
    public void onClose(Player player) {

    }
}
