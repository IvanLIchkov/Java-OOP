package Vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImp implements VehicleInterface{
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public VehicleImp(double fuelQuantity, double tankCapacity, double fuelConsumption) {
        setTankCapacity(tankCapacity);
        setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
    }


    public void setTankCapacity(double tankCapacity) {
        if (fuelQuantity>this.tankCapacity){
            System.out.println("Cannot fit fuel in tank");
        }else {
            this.tankCapacity=tankCapacity;
        }
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    @Override
    public void refuel(double litres) {
        if (litres<=0){
            System.out.println("Fuel must be a positive number");
        }else if (litres+getFuelQuantity()>getTankCapacity()){
            System.out.println("Cannot fit fuel in tank");
        } else {
            setFuelQuantity(getFuelQuantity() + litres);
        }
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity<0){
            System.out.println("Fuel must be a positive number");
        }else {
            this.fuelQuantity=fuelQuantity;
        }
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
