package Vehicles;

public class Truck extends VehicleImp{
    private static final double FUEL_CONSUMPTION_INCREASE=1.6;

    public Truck(double fuelQuantity, double tankCapacity, double fuelConsumption) {
        super(fuelQuantity, tankCapacity, fuelConsumption+FUEL_CONSUMPTION_INCREASE);
    }

    @Override
    public void drive(double km) {
        super.drive(km);
    }

    @Override
    public void refuel(double litres) {
        super.refuel(litres*0.95);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
