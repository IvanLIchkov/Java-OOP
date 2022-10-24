package CardSuit;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        System.out.println("Card Suits:");
//        Arrays.stream(Suits.values()).forEach(e-> System.out.printf("Ordinal value: %d; Name value: %s%n",e.ordinal(),e.name()));

//        System.out.println("Card Ranks:");
//        Arrays.stream(Ranks.values()).forEach(r-> System.out.printf("Ordinal value: %d; Name value: %s%n",r.ordinal(),r.name()));
        Ranks cardRanks = Ranks.valueOf(scan.nextLine());
        Suits cardSuits = Suits.valueOf(scan.nextLine());

        Card card = new Card(cardSuits, cardRanks);

        System.out.printf("Card name: %s of %s; Card power: %d%n", card.getCardRank(), card.getCardSuits(), card.getPower());
    }
}
