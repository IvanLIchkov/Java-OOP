package PizzaCalories;

public enum ToppingsModifiers {
    MEAT(1.2),
    VEGGIES(0.8),
    CHEESE(1.1),
    SAUCE(0.9);
    private double modifier;

    ToppingsModifiers(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }
    public static ToppingsModifiers parse(String topping){
        switch (topping){
            case "Meat":
                return MEAT;
            case "Veggies":
                return VEGGIES;
            case "Cheese":
                return CHEESE;
            case "Sauce":
                return SAUCE;
            default:
                throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.",topping));
        }
    }
}
