package com.stas.alcoholic;

import com.stas.alcoholic.cards.Card;
import com.stas.alcoholic.cards.CardUtil;
import com.stas.alcoholic.decks.Deck;
import com.stas.alcoholic.decks.Hand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Game {
    static Game game = new Game();

    boolean hasLoser = false;
    Deck deck = new Deck();
    List<Hand> hands;
    List<Card> table = new LinkedList<>();

    public void randomDeck() {
        deck.addCards(CardUtil.getStrippedDeck());
        deck.shuffle();
    }

    public void customDeck(BufferedReader console) throws IOException {
        System.out.println("Cards=================");
        String input;
        while ((input = console.readLine()) != null && !input.isEmpty()) {
            deck.addCard(CardUtil.getCardsByString(input));
        }
    }

    public void run() {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));) {
            System.out.println("Random(r) / Custom(c) deck?");
            String input = console.readLine();
            System.out.println();

            switch (input.toLowerCase()) {
                case "r" -> randomDeck();
                case "c" -> customDeck(console);
                default -> throw new IllegalStateException("Wrong input");
            }

            System.out.print("Deck==================");
            System.out.println(deck);
            System.out.println();

            System.out.println("NumberOfPlayers========");
            int players = Integer.parseInt(console.readLine());
            System.out.println();

            deck.deal(players);
            hands = deck.getHands();

            System.out.println("PlayerNames============");
            for (Hand hand : hands) {
                hand.setOwner(console.readLine());
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }

        int i = 0;
        int gambits = 0;
        outer:
        while (true) {
            for (; ; i++) {
                if (hasLoser) break outer;
                System.out.println("Round " + (++gambits) + ":");
                System.out.println("Hands==================");
                hands.forEach(System.out::println);

                Hand hand = hands.get(i % hands.size());
                table.add(hand.removeCard());

                System.out.println("Table==================");
                System.out.println(table);
                System.out.println();

                // check for round loser
                if (isCardLess()) {
                    hand.grab(table);
                    table = new LinkedList<>();
                }

                // check for empty hands
                Iterator<Hand> iterator = hands.iterator();
                while (iterator.hasNext()) {
                    Hand h = iterator.next();
                    if (h.isEmpty()) {
                        iterator.remove();
                        checkForLoser();
                        i--;
                    }
                }
            }
        }

        System.out.println("Gambits=================");
        System.out.println(gambits);
        System.out.println();

        System.out.println("Loser===================");
        System.out.println(hands.get(0).getOwner());
    }

    public void checkForLoser() {
        if (hands.size() < 2)
            hasLoser = true;
    }

    // card two is an upper card
    public boolean isCardLess() {
        if (table.size() < 2) return false;
        int valueOne = table.get(table.size() - 2).getRank().getValue();
        int valueTwo = table.get(table.size() - 1).getRank().getValue();
        if (valueOne == deck.getMax() && valueTwo == deck.getMin()) return false;
        return valueOne > valueTwo;
    }

    public static void main(String[] args) {
        game.run();
    }

}
