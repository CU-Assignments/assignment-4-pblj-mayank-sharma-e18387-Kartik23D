import java.util.*;

class Card {
    String symbol;
    int number;

    Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    public String toString() {
        return symbol + " " + number;
    }
}

public class Ass_4_Med {
    static Collection<Card> cards = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addCard() {
        System.out.print("Enter Symbol: ");
        String symbol = sc.next();
        System.out.print("Enter Number: ");
        int number = sc.nextInt();
        cards.add(new Card(symbol, number));
    }

    static void findCardsBySymbol() {
        System.out.print("Enter Symbol to search: ");
        String symbol = sc.next();
        cards.stream().filter(c -> c.symbol.equalsIgnoreCase(symbol)).forEach(System.out::println);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("1.Add Card 2.Find Cards 3.Exit");
            switch (sc.nextInt()) {
                case 1:
                    addCard();
                    break;
                case 2:
                    findCardsBySymbol();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}