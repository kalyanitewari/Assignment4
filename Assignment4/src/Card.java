import java.util.*;

class Card {
    private int rank;
    private int suit;

    public Card() {
        // Default constructor
    }

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public void createDeck(Vector<Card> deck) {
        for (int suit = 1; suit <= 4; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                deck.add(new Card(rank, suit));
            }
        }
    }

    public void printCard() {
        System.out.println("Card - Rank: " + rank + ", Suit: " + suit);
    }

    public void printDeck(Vector<Card> deck) {
        for (Card card : deck) {
            card.printCard();
        }
    }

    public boolean sameCard(Card otherCard) {
        return this.rank == otherCard.getRank() && this.suit == otherCard.getSuit();
    }

    public int compareCard(Card otherCard) {
        if (this.rank != otherCard.getRank()) {
            return Integer.compare(this.rank, otherCard.getRank());
        } else {
            return Integer.compare(this.suit, otherCard.getSuit());
        }
    }

    public void sortDeck(Vector<Card> deck) {
        Collections.sort(deck, Comparator.comparing(Card::getRank).thenComparing(Card::getSuit));
    }

    public void findCard(Vector<Card> deck, Card targetCard) {
        for (Card card : deck) {
            if (card.sameCard(targetCard)) {
                System.out.println("Card found in the deck:");
                card.printCard();
                return;
            }
        }
        System.out.println("Card not found in the deck.");
    }

    public void dealCards(Vector<Card> deck) {
        Random random = new Random();
        System.out.println("Dealing 5 random cards:");
        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(deck.size());
            Card randomCard = deck.get(randomIndex);
            randomCard.printCard();
            deck.remove(randomIndex);
        }
    }
}


