package com.stas.alcoholic.cards;

public enum Rank {
    TWO("2", 2), THREE("3", 3),
    FOUR("4", 4), FIVE("5", 5),
    SIX("6", 6), SEVEN("7", 7),
    EIGHT("8", 8), NINE("9", 9),
    TEN("10", 10), JACK("JACK", 11),
    QUEEN("QUEEN", 12), KING("KING", 13),
    ACE("ACE", 14);

    private final String word;
    private final int value;

    @Override
    public String toString() {
        return word;
    }

    Rank(String word, int value) {
        this.word = word;
        this.value = value;
    }

    public String getWord() {
        return word;
    }

    public int getValue() {
        return value;
    }
}
