package com.stas.alcoholic.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CardUtil {

    public static List<Card> getCards(Rank rank) {
        List<CardPattern> patterns = new ArrayList<>();
        for (CardPattern pattern : CardPattern.values()) {
            if (pattern.getRank() == rank)
                patterns.add(pattern);
        }

        return patterns.stream()
                .map(Card::new)
                .collect(Collectors.toList());
    }

    public static List<Card> getCards(Suit suit) {
        List<CardPattern> patterns = new ArrayList<>();
        for (CardPattern pattern : CardPattern.values()) {
            if (pattern.getSuit() == suit)
                patterns.add(pattern);
        }

        return patterns.stream()
                .map(Card::new)
                .collect(Collectors.toList());
    }

}
