package factoryExercise;

import factoryExercise.cakes.Cake;
import factoryExercise.cakes.CakeFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String cakeType = scan.nextLine();
       Cake cake = PastryShop.orderCake(cakeType);

    }
}
