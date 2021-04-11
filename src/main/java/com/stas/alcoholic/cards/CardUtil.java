package com.stas.alcoholic.cards;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CardUtil {
    public static List<Card> getCardsByRank(Rank rank) {
        return Arrays.stream(Suit.values())
                .map(suit -> new Card(suit, rank))
                .collect(Collectors.toList());
    }

    public static List<Card> getCardsBySuit(Suit suit) {
        return Arrays.stream(Rank.values())
                .map(rank -> new Card(suit, rank))
                .collect(Collectors.toList());
    }

    public static Card getCard(Suit suit, Rank rank) {
        if (suit == null || rank == null)
            throw new IllegalStateException("Null");

        return new Card(suit, rank);
    }

    public static Card getCardsByString(String string) {
        if (string.length() != 2) throw new IllegalStateException("Wrong input");
        Suit suit = null;
        Rank rank = null;
        for (String part : string.split("")) {
            switch (part.toUpperCase()) {
                // 1 - is a 10
                case "1" -> rank = Rank.TEN;
                case "2" -> rank = Rank.TWO;
                case "3" -> rank = Rank.THREE;
                case "4" -> rank = Rank.FOUR;
                case "5" -> rank = Rank.FIVE;
                case "6" -> rank = Rank.SIX;
                case "7" -> rank = Rank.SEVEN;
                case "8" -> rank = Rank.EIGHT;
                case "9" -> rank = Rank.NINE;
                case "J" -> rank = Rank.JACK;
                case "Q" -> rank = Rank.QUEEN;
                case "K" -> rank = Rank.KING;
                case "A" -> rank = Rank.ACE;
                case "H" -> suit = Suit.HEART;
                case "D" -> suit = Suit.DIAMOND;
                case "C" -> suit = Suit.CLUB;
                case "S" -> suit = Suit.SPADE;
            }
        }

        return getCard(suit, rank);
    }
}
