package com.stas.alcoholic.cards;

enum Suit {
    HEART("ЧЕРВА"),
    DIAMOND("БУБНА"),
    CLUB("ТРЕФА"),
    SPADE("ПИКА");

    @Override
    public String toString() {
        return word;
    }

    private final String word;

    Suit(String word) {
        this.word = word;
    }
}