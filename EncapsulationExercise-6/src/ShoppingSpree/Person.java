package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (product==null){
            throw new IllegalArgumentException();
        }
        if (product.getCost() <= money) {
            products.add(product);
            money=(money - product.getCost());
            System.out.printf("%s bought %s%n", name, product.getName());
        } else {
            System.out.printf("%s can't afford %s%n", name, product.getName());
        }
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        if (this.products.isEmpty()) {
            return this.name + " - Nothing bought";
        }
        return this.name +
                " - " +
                this.products
                        .stream()
                        .map(Product::toString)
                        .collect(Collectors.joining(", "));
    }
}
