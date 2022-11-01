package Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       Car car=null;
       Truck truck=null;
       Bus bus=null;
        for (int i = 0; i <3 ; i++) {
            String[] tokens=scan.nextLine().split("\\s+");
            String typeOfVehicle=tokens[0];
            double fuelQuantity=Double.parseDouble(tokens[1]);
            double tankCapacity=Double.parseDouble(tokens[3]);
            double fuelConsumption=Double.parseDouble(tokens[2]);
            switch (typeOfVehicle){
                case "Car":
                    car=new Car(fuelQuantity,tankCapacity,fuelConsumption);
                    break;
                case "Truck":
                    truck=new Truck(fuelQuantity,tankCapacity,fuelConsumption);
                    break;
                case "Bus":
                    bus=new Bus(fuelQuantity,tankCapacity,fuelConsumption);
            }
        }
        int numberOfCommands=Integer.parseInt(scan.nextLine());
        for (int i = 0; i <numberOfCommands; i++) {
            String[] commands=scan.nextLine().split("\\s+");
            String typeOfVehicle=commands[1];
            String typeOfAction=commands[0];
            double quantity=Double.parseDouble(commands[2]);
            switch (typeOfVehicle){
                case "Car":
                    if (typeOfAction.equals("Drive")){
                        car.drive(quantity);
                    }else {
                        car.refuel(quantity);
                    }
                    break;
                case "Truck":
                    if (typeOfAction.equals("Drive")){
                        truck.drive(quantity);
                    }else {
                        truck.refuel(quantity);
                    }
                    break;
                case "Bus":
                    if (typeOfAction.equals("Drive")){
                        bus.drive(quantity);
                    }else if (typeOfAction.equals("DriveEmpty")){
                        bus.driveEmpty(quantity);
                    }else {
                        bus.refuel(quantity);
                    }
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
