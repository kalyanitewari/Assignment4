import java.util.Scanner;
import java.util.Vector;

public class CardGameMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Card> deck = new Vector<>();

        Card card = new Card();
        card.createDeck(deck);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Print Deck");
            System.out.println("2. Same Card Check");
            System.out.println("3. Compare Cards");
            System.out.println("4. Sort Deck");
            System.out.println("5. Find Card");
            System.out.println("6. Deal Cards");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    card.printDeck(deck);
                    break;
                case 2:
                    System.out.println("Enter card details to check if it's in the deck:");
                    Card cardToCheck = new Card(scanner.nextInt(), scanner.nextInt());
                    System.out.println("Same Card Check: " + card.sameCard(cardToCheck));
                    break;
                case 3:
                    System.out.println("Enter two cards to compare:");
                    Card firstCard = new Card(scanner.nextInt(), scanner.nextInt());
                    Card secondCard = new Card(scanner.nextInt(), scanner.nextInt());
                    System.out.println("Comparison Result: " + firstCard.compareCard(secondCard));
                    break;
                case 4:
                    card.sortDeck(deck);
                    System.out.println("Deck sorted.");
                    break;
                case 5:
                    System.out.println("Enter card details to find in the deck:");
                    Card cardToFind = new Card(scanner.nextInt(), scanner.nextInt());
                    card.findCard(deck, cardToFind);
                    break;
                case 6:
                    card.dealCards(deck);
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}