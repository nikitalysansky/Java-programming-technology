import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    // Список мастей и рангов
    private static final String[] SUITS = {"♠", "♥", "♦", "♣"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    // Колода карт
    private List<String> deck;

    // Сброшенные карты
    private List<String> discardedCards;

    public CardDeck() {
        this.deck = new ArrayList<>();
        this.discardedCards = new ArrayList<>();
        initializeDeck();
    }

    // Создание полной колоды
    private void initializeDeck() {
        deck.clear();
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck.add(rank + suit);
            }
        }
    }

    // Перетасовка колоды
    public void shuffle() {
        Collections.shuffle(deck);
    }

    // Сдача карты
    public String dealCard() {
        if (deck.isEmpty()) {
            System.out.println("Колода пуста!");
            return null;
        }
        String card = deck.remove(deck.size() - 1);
        discardedCards.add(card);
        return card;
    }

    // Возвращение карты в колоду
    public void returnCard(String card) {
        if (deck.contains(card) || discardedCards.contains(card)) {
            System.out.println("Эта карта уже есть в колоде: " + card);
            return;
        }
        deck.add(card);
    }

    // Печать текущей колоды
    public void printDeck() {
        System.out.println("Текущая колода: " + deck);
    }

    // Печать сброшенных карт
    public void printDiscarded() {
        System.out.println("Сброшенные карты: " + discardedCards);
    }

    public static void main(String[] args) {
        CardDeck cardDeck = new CardDeck();

        System.out.println("Изначальная колода:");
        cardDeck.printDeck();

        System.out.println("\nПеретасовка колоды...");
        cardDeck.shuffle();
        cardDeck.printDeck();

        System.out.println("\nСдача карты...");
        String dealtCard = cardDeck.dealCard();
        System.out.println("Сданная карта: " + dealtCard);

        System.out.println("\nКолода после сдачи:");
        cardDeck.printDeck();
        cardDeck.printDiscarded();

        System.out.println("\nВозвращение карты в колоду...");
        cardDeck.returnCard(dealtCard);
        cardDeck.printDeck();

        System.out.println("\nПопытка вернуть ту же карту...");
        cardDeck.returnCard(dealtCard);
    }
}
