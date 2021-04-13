package com.stas.alcoholic.cards;

enum Suit {
    HEART("HEART"),
    DIAMOND("DIAMOND"),
    CLUB("CLUB"),
    SPADE("SPADE");

    @Override
    public String toString() {
        return word;
    }

    private final String word;

    Suit(String word) {
        this.word = word;
    }
}