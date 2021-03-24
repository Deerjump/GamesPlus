package io.github.deerjump.gamesplus.games.cards;

import io.github.deerjump.builders.BannerBuilder;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.inventory.ItemStack;

import java.util.List;

import static io.github.deerjump.gamesplus.games.cards.BannerLetters.*;

public class Card {
    private final int value;
    private final int id;
    private final Suit suit;
    private ItemStack item;

    public Card(Suit suit, int value, int id) {
        this.suit = suit;
        this.value = Math.min(value, 10);
        this.id = id;
    }

    public ItemStack getItem() {
        if (item == null) generateItem();
        return item;
    }

    public int getValue() {
        return this.value;
    }

    public String getName() {
        return String.format("%s of %s", idToName(), suit.getName());
    }

    private void generateItem() {
        BannerBuilder builder = new BannerBuilder(Material.WHITE_BANNER)
                .name(getName())
                .addPatterns(getDesign());
        if (id == 10)
            builder.amount(id);

        item = builder.build();
    }

    private List<Pattern> getDesign() {
        List<Pattern> design;
        switch (id) {
            case 1: { design = ONE(suit.getColor()); break; }
            case 2: { design = TWO(suit.getColor()); break; }
            case 3: { design = THREE(suit.getColor()); break; }
            case 4: { design = FOUR(suit.getColor()); break; }
            case 5: { design = FIVE(suit.getColor()); break; }
            case 6: { design = SIX(suit.getColor()); break; }
            case 7: { design = SEVEN(suit.getColor()); break; }
            case 8: { design = EIGHT(suit.getColor()); break; }
            case 9: { design = NINE(suit.getColor()); break; }
            case 10: { design = ZERO(suit.getColor()); break; }
            case 11: { design = JACK(suit.getColor()); break; }
            case 12: { design = QUEEN(suit.getColor()); break; }
            case 13: { design = KING(suit.getColor()); break; }
            default: { throw new IllegalArgumentException("Value must be 1-13. Provided: " + id); }
        }
        return design;
    }

    private String idToName() {
        switch (id) {
            case 1: { return "Ace"; }
            case 2: { return "Two"; }
            case 3: { return "Three"; }
            case 4: { return "Four"; }
            case 5: { return "Five"; }
            case 6: { return "Six"; }
            case 7: { return "Seven"; }
            case 8: { return "Eight"; }
            case 9: { return "Nine"; }
            case 10: { return "Ten"; }
            case 11: { return "Jack"; }
            case 12: { return "Queen"; }
            case 13: { return "King"; }
            default: { throw new IllegalArgumentException("Value must be 1-13. Provided: " + id); }
        }
    }
}
