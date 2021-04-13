package com.stas.alcoholic.decks;

import com.stas.alcoholic.cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// custom deck
public class Deck {
    protected List<Card> cards = new LinkedList<>();
    protected List<Hand> hands;
    protected Integer max;         // more than 14 (A)
    protected Integer min;          // less than 10 (1)

    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Card card : cards) {
            builder.append("\n\t").append(card.toString());
        }

        return builder.toString();
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Hand> getHands() {
        return hands;
    }

    public Integer getMax() {
        return max;
    }

    public Integer getMin() {
        return min;
    }

    public void deal(int players) {
        if (players < 2)
            throw new IllegalStateException("Need more players for dealing!");

        int cardsOnHand = size() / players;
        if (cardsOnHand < 1)
            throw new IllegalStateException("Need more cards or less players!");

        hands = new ArrayList<>();
        for (int i = 0; i < players; i++) {
            hands.add(new Hand());
        }
        for (int i = 0; i < cardsOnHand; i++) {
            for (int j = 0; j < players; j++) {
                Card currentCard = removeCard();
                hands.get(j).addCard(currentCard);
            }
        }
        Collections.reverse(hands);
    }

    protected void checkMinAndMaxRanks() {
        min = 15;
        max = 0;
        for (Card card : cards) {
            int current = card.getRank().getValue();
            if (current < min)
                min = current;
            if (current > max)
                max = current;
        }
    }

    public void addCard(Card card) {
        if (cards.contains(card)) {
            System.out.println("This card is already added");
            return;
        }

        cards.add(card);
        checkMinAndMaxRanks();
    }

    public void addCards(List<Card> cards) {
        for (Card c : cards)
            addCard(c);
    }

    public Card removeCard() {
        Card remove = cards.remove(0);
//        checkMinAndMaxRanks();
        return remove;
    }

    public void removeCard(Card card) {
        if (cards.size() < 1) {
            System.out.println("No cards!");
            return;
        }
        if (!cards.contains(card)) {
            System.out.println("This card isn't added yet");
            return;
        }
        cards.remove(card);
        checkMinAndMaxRanks();
    }

    public void removeCards(List<Card> cards) {
        for (Card c : cards)
            removeCard(c);
    }

    public int size() {
        return cards.size();
    }
}
