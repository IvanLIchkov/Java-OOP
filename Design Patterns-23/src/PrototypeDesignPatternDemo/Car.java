package PrototypeDesignPatternDemo;

public class Car implements Cloneable<Car> {
    private String make;
    private String model;
    private int year;
    private String color;
    private int horsepower;

    public Car(String make, String model, int year, String color, int horsepower) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.horsepower = horsepower;
    }

    @Override
    public Car clone() {
        return new Car(make, model, year, color,horsepower);
    }
}
