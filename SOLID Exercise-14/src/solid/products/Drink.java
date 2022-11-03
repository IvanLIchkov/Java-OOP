package solid.products;

public abstract class Drink {
    private final double density;
    private final double milliliters;

    public Drink(double density, double milliliters) {
        this.density = density;
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }
    public double getDensity(){
        return this.density;
    }

    double getDrinkAmountInLiters(){
        return (this.getMilliliters()/1000)*this.getDensity();
    }
}
