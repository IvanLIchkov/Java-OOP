package Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokensCar=scan.nextLine().split("\\s+");
        String[] tokensTruck=scan.nextLine().split("\\s+");
        Car car=new Car(Double.parseDouble(tokensCar[1]),Double.parseDouble(tokensCar[2]));
        Truck truck=new Truck(Double.parseDouble(tokensTruck[1]),Double.parseDouble(tokensTruck[2]));
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
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}
