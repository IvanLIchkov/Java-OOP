package NeedForSpeed;

public class Main {
    public static void main(String[] args) {
        SportCar sportCar= new SportCar(11,150);
        sportCar.drive(1);
        System.out.println(sportCar.getFuel());
    }
}
