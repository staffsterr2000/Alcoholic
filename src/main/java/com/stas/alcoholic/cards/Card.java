package com.stas.alcoholic.cards;

import java.util.Objects;

public class Card {
    private final Suit suit;
    private final Rank rank;

    @Override
    public String toString() {
        return suit + " " + rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit && rank == card.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    public Card(CardPattern pattern) {
        this.suit = pattern.getSuit();
        this.rank = pattern.getRank();
    }

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

}
