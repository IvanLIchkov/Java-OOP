package solid.products;

public class Chocolate extends Food implements Product {

    private static final double CALORIES_PER_100_GRAMS = 575.0;

    public Chocolate(double grams) {
        super(grams);
    }

    @Override
    public double getAmountOfCalories() {
        return this.getGrams() * (CALORIES_PER_100_GRAMS / 100);
    }
}
