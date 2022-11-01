package Vehicles;

public class Truck extends VehicleImp{
    private double fuelQuantity;
    private double fuelConsumption;

    public Truck(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption+1.6;
    }

    @Override
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public double getFuelQuantity() {
        return fuelQuantity;
    }

    @Override
    public void drive(double km) {
        super.drive(km);
    }

    @Override
    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
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
