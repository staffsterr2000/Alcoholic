package com.stas.alcoholic.cards;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.stas.alcoholic.cards.Rank.*;
import static com.stas.alcoholic.cards.Suit.*;

public class CardUtil {
    public static List<Card> getStandardDeck() {
        return getCardsByRank(
                TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
                NINE, TEN, JACK, QUEEN, KING, ACE
        );
    }

    public static List<Card> getStrippedDeck() {
        return getCardsByRank(
                SIX, SEVEN, EIGHT, NINE, TEN,
                JACK, QUEEN, KING, ACE
        );
    }

    public static List<Card> getCardsByRank(Rank... ranks) {
        return Arrays.stream(ranks)
                .flatMap(rank -> Arrays.stream(Suit.values())
                        .map(suit -> new Card(suit, rank))
                )
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
                case "1" -> rank = TEN;
                case "2" -> rank = TWO;
                case "3" -> rank = THREE;
                case "4" -> rank = FOUR;
                case "5" -> rank = FIVE;
                case "6" -> rank = SIX;
                case "7" -> rank = SEVEN;
                case "8" -> rank = EIGHT;
                case "9" -> rank = NINE;
                case "J" -> rank = JACK;
                case "Q" -> rank = QUEEN;
                case "K" -> rank = KING;
                case "A" -> rank = ACE;
                case "H" -> suit = HEART;
                case "D" -> suit = DIAMOND;
                case "C" -> suit = CLUB;
                case "S" -> suit = SPADE;
            }
        }

        return getCard(suit, rank);
    }
}
