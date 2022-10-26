package PizzaCalories;

public enum DoughModifiers {
    WHITE(1.5),
    WHOLEGRAIN(1),
    CRISPY(0.9),
    CHEWY(1.1),
    HOMEMADE(1);
    private double modifier;

    DoughModifiers(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return modifier;
    }
    public static  DoughModifiers parse(String dough){
        switch (dough){
            case "White":
                return WHITE;
            case "Wholegrain":
                return WHOLEGRAIN;
            case "Crispy":
                return CRISPY;
            case "Chewy":
                return CHEWY;
            case "Homemade":
                return HOMEMADE;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }
    }
}
