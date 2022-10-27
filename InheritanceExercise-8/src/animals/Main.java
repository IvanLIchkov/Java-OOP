package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String typeOfAnimal = scan.nextLine();
        List<Animal> animals = new ArrayList<>();
        while (!typeOfAnimal.equals("Beast!")) {
            try {
                String[] animalInfo = scan.nextLine().split("\\s+");
                String name = animalInfo[0];
                int age = Integer.parseInt(animalInfo[1]);
                String gender = animalInfo[2];
                switch (typeOfAnimal) {
                    case "Dog":
                        Dog dog = new Dog(name, age, gender);
                        animals.add(dog);
                        break;
                    case "Cat":
                        Cat cat = new Cat(name, age, gender);
                        animals.add(cat);
                        break;
                    case "Frog":
                        Frog frog = new Frog(name, age, gender);
                        animals.add(frog);
                        break;
                    case "Kittens":
                        Kitten kitten = new Kitten(name, age);
                        animals.add(kitten);
                        break;
                    case "Tomcat":
                        Tomcat tomCat = new Tomcat(name, age);
                        animals.add(tomCat);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid input!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            typeOfAnimal = scan.nextLine();
        }
        animals.forEach(a -> {
            System.out.print(a.toString());
            a.produceSound();
        });
    }
}
