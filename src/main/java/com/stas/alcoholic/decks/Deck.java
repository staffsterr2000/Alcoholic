package com.stas.alcoholic.decks;

import com.stas.alcoholic.cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Deck {
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Deck{");
        for (Card card : cards) {
            builder.append("\n\t").append(card.toString());
        }
        builder.append("\n}");

        return builder.toString();
    }

    protected List<Card> cards = new ArrayList<>();

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        if (cards.contains(card))
            throw new IllegalStateException("This card is already added");
        cards.add(card);
    }

    public void addCards(List<Card> cards) {
        for (Card c : cards)
            addCard(c);
    }

    public void removeCard(Card card) {
        if (!cards.contains(card))
            throw new IllegalStateException("This card isn't added yet");
        cards.remove(card);
    }

    public void removeCards(List<Card> cards) {
        for (Card c : cards)
            removeCard(c);
    }
}
