package io.github.deerjump.gamesplus.games.cards;

import org.bukkit.DyeColor;

public enum Suit {
    HEARTS("Hearts", DyeColor.RED),
    CLUBS("Clubs", DyeColor.BLUE),
    SPADES("Spades", DyeColor.BLACK),
    DIAMONDS("Diamonds", DyeColor.GREEN);

    private final String name;
    private DyeColor color;

    Suit(String name, DyeColor color){
        this.name = name;
        this.color = color;
    }

    public String getName(){
        return this.name;
    }

    public DyeColor getColor() {
        return this.color;
    }
}
