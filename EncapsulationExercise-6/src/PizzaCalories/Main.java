package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] pizzaData = scan.nextLine().split("\\s+");
        String name = pizzaData[1];
        int toppingNumbers = Integer.parseInt(pizzaData[2]);

        Pizza pizza = null;
        try {
            pizza = new Pizza(name, toppingNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }


        String[] doughTokens = scan.nextLine().split("\\s+");
        String doughType = doughTokens[1];
        String bakingTechnique = doughTokens[2];
        double weight = Double.parseDouble(doughTokens[3]);
        Dough dough = null;
        try {
            dough = new Dough(doughType, bakingTechnique, weight);
            pizza.setDough(dough);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String command = scan.nextLine();
        while (!command.equals("END") && toppingNumbers-- > 0) {
            String[] toppingTokens = command.split("\\s+");
            String toppingType = toppingTokens[1];
            double toppingWeight = Double.parseDouble(toppingTokens[2]);
            try {
                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
            command = scan.nextLine();
        }


        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}
