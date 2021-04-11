package com.stas.alcoholic.cards;

public enum Rank {
    TWO("2", 2), THREE("3", 3),
    FOUR("4", 4), FIVE("5", 5),
    SIX("6", 6), SEVEN("7", 7),
    EIGHT("8", 8), NINE("9", 9),
    TEN("10", 10), JACK("ВАЛЕТ", 11),
    QUEEN("ДАМА", 12), KING("КОРОЛЬ", 13),
    ACE("ТУЗ", 14);

    private final String word;
    private final int value;

    @Override
    public String toString() {
        return word + "(" + value + ")";
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
