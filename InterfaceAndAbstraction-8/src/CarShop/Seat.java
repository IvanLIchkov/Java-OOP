package CarShop;

public class Seat extends CarImpl implements Sellable {
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public String toString() {
        System.out.printf("This is %s produced in %s and have %d tires%n",getModel(), countryProduced(), Car.TIRE);
        return String.format("%s sells for %f", getModel(), price);
    }

    @Override
    public Double getPrice() {
        return price;
    }
}

