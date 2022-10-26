package PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int toppingNumber;

    public Pizza(String name,  int toppingNumber) {
        setName(name);
        setToppings(toppingNumber);
        this.toppings=new ArrayList<>(this.toppingNumber);
    }

    public String getName() {
        return name;
    }

    public Dough getDough() {
        return dough;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setName(String name) {
        if (name.trim().isEmpty()||name.length()<1||name.length()>15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name=name;
    }
    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int toppings) {
        if (toppings<0||toppings>10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }
    public double getOverallCalories(){
        double calories = dough.calculateCalories();
        for (Topping topping : toppings) {
            calories += topping.calculateCalories();
        }
        return calories;
    }

}
