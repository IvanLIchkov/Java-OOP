package ShoppingSpree;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        String[] peopleInfo = scan.nextLine().split(";");
        for (String person : peopleInfo) {
            String[] tokens = person.split("=");
            String name = tokens[0];
            double money = Double.parseDouble(tokens[1]);
            try{
                Person personToAdd = new Person(name, money);
                people.add(personToAdd);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }

        }
        List<Product> products = new ArrayList<>();
        String[] productInfo = scan.nextLine().split(";");
        for (String product : productInfo) {
            String[] tokens = product.split("=");
            String name = tokens[0];
            double cost = Double.parseDouble(tokens[1]);
            try {
                Product productToAdd = new Product(name, cost);
                products.add(productToAdd);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
        }
        String command = scan.nextLine();
        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];
            Product product = products.stream()
                    .filter(p -> p.getName()
                            .equals(productName))
                    .findFirst()
                    .orElse(null);
            people.stream()
                    .filter(p -> p.getName()
                            .equals(personName))
                    .forEach(p -> p.buyProduct(product));
            command = scan.nextLine();
        }
        people.stream().forEach(p -> {
            System.out.printf("%s - ", p.getName());
            if (p.getProducts().size() > 0) {
                List<String> productNames = new ArrayList<>();
                p.getProducts().forEach(product -> productNames.add(product.getName()));
                System.out.println(String.join(", ", productNames));
            } else {
                System.out.println("Nothing bought");
            }
        });
    }
}
