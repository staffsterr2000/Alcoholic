package com.stas.alcoholic.cards;

enum Suit {
    HEART("ЧЕРВА"),
    DIAMOND("БУБНА"),
    CLUB("ТРЕФА"),
    SPADE("ПИКА");

    private final String suit;
    Suit(String suit) {
        this.suit = suit;
    }
    public String getSuit() {
        return suit;
    }
}