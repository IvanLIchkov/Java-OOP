package WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        List<AnimalInterface> animals=new ArrayList<>();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String animalType = tokens[0];
            String animalName = tokens[1];
            Double animalWeight = Double.parseDouble(tokens[2]);
            String livingRegion = tokens[3];
            AnimalInterface animal = null;
            switch (animalType) {
                case "Cat":
                    String bread = tokens[4];
                    animal = new Cat(animalName, animalType, animalWeight, livingRegion, bread);
                    break;
                case "Tiger":
                    animal = new Tiger(animalName, animalType, animalWeight, livingRegion);
                    break;
                case "Mouse":
                    animal = new Mouse(animalName, animalType, animalWeight, livingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(animalName, animalType, animalWeight, livingRegion);
                    break;
            }
            Food food = null;
            String[] foodTokens=scan.nextLine().split("\\s+");
            String typeOfFood = foodTokens[0];
            Integer quantity = Integer.parseInt(foodTokens[1]);
            if (typeOfFood.equals("Vegetable")) {
                food = new Vegetable(quantity);
            } else {
                food = new Meat(quantity);
            }
            animal.makeSound();
            animal.eat(food);
            animals.add(animal);
            command= scan.nextLine();
        }
        for (AnimalInterface animal : animals) {
            System.out.println(animal);
        }

    }
}
