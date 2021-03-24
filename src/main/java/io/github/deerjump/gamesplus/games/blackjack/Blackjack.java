package io.github.deerjump.gamesplus.games.blackjack;

import io.github.deerjump.gamesplus.games.Winner;
import io.github.deerjump.gamesplus.games.cards.Card;
import io.github.deerjump.gamesplus.games.cards.Deck;

import java.util.ArrayList;
import java.util.List;

public class Blackjack {
    private boolean started;
    private final Deck deck;
    private Winner winner;
    private boolean playerStayed;
    private boolean dealerStayed;
    private final List<Card> playerHand;
    private final List<Card> dealerHand;

    public Blackjack() {
        deck = new Deck();
        deck.shuffle();
        started = false;

        this.winner = Winner.NONE;
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
        playerDraw();
        dealerDraw();
        playerDraw();
        dealerDraw();
        checkWinner();
    }

    public int calcScore(List<Card> cards) {
        int scoreNoAces = cards.stream().filter(card -> card.getValue() != 1).mapToInt(Card::getValue).sum();

        int acePoints = cards.stream().filter(card -> card.getValue() == 1).mapToInt(ignored -> scoreNoAces + 11 > 21 ? 1 : 11).sum();

        return scoreNoAces + acePoints;
    }

    public int getPlayerScore() {
        return calcScore(playerHand);
    }

    public int getDealerScore() {
        return calcScore(dealerHand);
    }

    public Winner getWinner() {
        return this.winner;
    }

    public boolean isStarted() {
        return started;
    }

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public List<Card> getDealerHand() {
        return dealerHand;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public void playerDraw() {
        if (winner != Winner.NONE) return;
        Card card = deck.draw();
        playerHand.add(card);
    }

    private void dealerDraw() {
        if (winner != Winner.NONE) return;
        if (getDealerScore() >= 18) {
            dealerStayed = true;
            return;
        }

        Card card = deck.draw();
        dealerHand.add(card);
    }

    private void checkWinner() {
        int playerScore = getPlayerScore();
        int dealerScore = getDealerScore();

        if (dealerStayed && playerStayed) {
            if (playerScore == dealerScore)
                winner = Winner.DRAW;
            else if (playerScore > dealerScore)
                winner = Winner.PLAYER;
            else
                winner = Winner.DEALER;
        }

        if (playerScore > 21 && dealerScore > 21)
            winner = Winner.DRAW;
        if( playerScore > 21 && dealerScore < 21)
            winner = Winner.DEALER;
        if (playerScore < 21 && dealerScore > 21)
            winner = Winner.PLAYER;
        if (dealerScore == 21 && playerScore == dealerScore )
            winner = Winner.DRAW;
        if (dealerScore == 21 && playerScore != dealerScore)
            winner = Winner.DEALER;
        if (playerScore == 21 && playerScore != dealerScore)
            winner = Winner.PLAYER;
    }

    public void hit() {
        playerDraw();
        dealerDraw();
        checkWinner();
    }

    public void stay() {
        playerStayed = true;
        System.out.println("Player stayed!");
        dealerDraw();
        checkWinner();
    }
}
