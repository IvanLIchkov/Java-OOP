package CarShop;

public class Seat extends CarImpl implements Sellable{
    private Double price;

    public Seat(String model, String color, int horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Double getPrice() {
        return price;
    }
}

