package com.stas.alcoholic.decks;

import com.stas.alcoholic.cards.Card;

import java.util.List;

public class Hand extends Deck {
    private String owner;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(owner).append("{");
        for (Card card : cards) {
            builder.append("\n\t").append(card.toString());
        }
        builder.append("\n}");

        return builder.toString();
    }

    @Override
    public void addCard(Card card) {
        if (cards.contains(card)) {
            System.out.println("This card is already added");
            return;
        }

        cards.add(0, card);
        checkMinAndMaxRanks();
    }

    public void grab(List<Card> table) {
        cards.addAll(table);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
