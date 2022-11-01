package Vehicles;

import java.text.DecimalFormat;

public class Bus extends VehicleImp {
    public static final double CONSUMPTION_INCREASE_IF_NOT_EMPTY = 1.4;

    public Bus(double fuelQuantity, double tankCapacity, double fuelConsumption) {
        super(fuelQuantity, tankCapacity, fuelConsumption);
    }

    public void driveEmpty(double km) {
      super.drive(km);
    }

    @Override
    public void drive(double km) {
        if (km * (getFuelConsumption() + CONSUMPTION_INCREASE_IF_NOT_EMPTY) > getFuelQuantity()) {
            System.out.println(getClass().getSimpleName() + " needs refueling");
        } else {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");

            System.out.printf("%s travelled %s km%n", getClass().getSimpleName(), decimalFormat.format(km));
            setFuelQuantity(getFuelQuantity() - km * (getFuelConsumption() + CONSUMPTION_INCREASE_IF_NOT_EMPTY));
        }
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
