package Vehicles;

public class Car extends VehicleImp {
    private static final double FUEL_CONSUMPTION_INCREASE=0.9;

    public Car(double fuelQuantity, double tankCapacity, double fuelConsumption) {
        super(fuelQuantity, tankCapacity, fuelConsumption+FUEL_CONSUMPTION_INCREASE);
    }

    @Override
    public void drive(double km) {
       super.drive(km);
    }

    @Override
    public void refuel(double litres) {
        super.refuel(litres);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
