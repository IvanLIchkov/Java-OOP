package CardSuit;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input=scan.nextLine();
        System.out.println("Card Suits:");
        Arrays.stream(Suits.values()).forEach(e-> System.out.printf("Ordinal value: %d; Name value: %s%n",e.ordinal(),e.name()));
    }
}
