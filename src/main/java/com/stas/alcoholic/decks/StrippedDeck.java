package com.stas.alcoholic.decks;

import com.stas.alcoholic.cards.CardUtil;
import com.stas.alcoholic.cards.Rank;

public class StrippedDeck extends Deck {

    public StrippedDeck() {
        addCards(CardUtil.getCardsByRank(Rank.SIX));
        removeCards(CardUtil.getCardsByRank(Rank.SIX));
        addCards(CardUtil.getCardsByRank(Rank.SEVEN));
        addCards(CardUtil.getCardsByRank(Rank.EIGHT));
        addCards(CardUtil.getCardsByRank(Rank.NINE));
        addCards(CardUtil.getCardsByRank(Rank.TEN));
        addCards(CardUtil.getCardsByRank(Rank.JACK));
        addCards(CardUtil.getCardsByRank(Rank.QUEEN));
        addCards(CardUtil.getCardsByRank(Rank.KING));
        addCards(CardUtil.getCardsByRank(Rank.ACE));
    }

}
