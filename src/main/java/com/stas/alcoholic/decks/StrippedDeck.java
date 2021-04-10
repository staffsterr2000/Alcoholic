package com.stas.alcoholic.decks;

import com.stas.alcoholic.cards.CardUtil;
import com.stas.alcoholic.cards.Rank;

public class StrippedDeck extends Deck {

    public StrippedDeck() {
        addCards(CardUtil.getCards(Rank.SIX));
        addCards(CardUtil.getCards(Rank.SEVEN));
        addCards(CardUtil.getCards(Rank.EIGHT));
        addCards(CardUtil.getCards(Rank.NINE));
        addCards(CardUtil.getCards(Rank.TEN));
        addCards(CardUtil.getCards(Rank.JACK));
        addCards(CardUtil.getCards(Rank.QUEEN));
        addCards(CardUtil.getCards(Rank.KING));
        addCards(CardUtil.getCards(Rank.ACE));
    }

}
