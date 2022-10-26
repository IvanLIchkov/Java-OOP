package PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String type) {
        switch (type) {
            case "Meat":
                this.toppingType = type;
                break;
            case "Veggies":
                this.toppingType = type;
                break;
            case "Cheese":
                this.toppingType = type;
                break;
            case "Sauce":
                this.toppingType = type;
                break;
            default:
                throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", type));
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        ToppingsModifiers toppingsModifiers = ToppingsModifiers.parse(toppingType);
        return (2 * weight) * toppingsModifiers.getModifier();
    }
}
