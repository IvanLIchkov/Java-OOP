package Vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImp implements VehicleInterface{
    private double fuelQuantity;
    private double fuelConsumption;
    @Override
    public void refuel(double litres) {
        setFuelQuantity(getFuelQuantity()+litres);
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    @Override
    public void drive(double km) {
        if (km*getFuelConsumption()>getFuelQuantity()){
            System.out.println(getClass().getSimpleName()+ " needs refueling");
        }else{
            DecimalFormat decimalFormat=new DecimalFormat("#.##");

            System.out.printf("%s travelled %s km%n",getClass().getSimpleName(),decimalFormat.format(km));
            setFuelQuantity(getFuelQuantity()-km*getFuelConsumption());
        }
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",getClass().getSimpleName(),getFuelQuantity());
    }
}
