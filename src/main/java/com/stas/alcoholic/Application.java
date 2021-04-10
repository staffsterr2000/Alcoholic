package com.stas.alcoholic;

import com.stas.alcoholic.decks.Deck;
import com.stas.alcoholic.decks.StrippedDeck;

public class Application {

    public static void main(String[] args) {

        Deck deck = new StrippedDeck();
        System.out.println(deck);

    }

}
