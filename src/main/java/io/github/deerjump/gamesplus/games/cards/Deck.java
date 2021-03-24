package io.github.deerjump.gamesplus.games.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {
    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        for(Suit suit : Suit.values()) {
            for (int i = 1; i <= 13; i++) {
                cards.add(new Card(suit, i, i));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card draw() {
        int random = ThreadLocalRandom.current().nextInt(cards.size());
        return cards.remove(random);
    }
}
