package HotelReservation;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input=scan.nextLine().split("\\s+");

        double pricePerDay=Double.parseDouble(input[0]);
        int numberOfDays=Integer.parseInt(input[1]);
        Season season=Season.parse(input[2]);
        DiscountType discountType=DiscountType.parse(input[3]);
        PriceCalculator priceCalculation=new PriceCalculator(pricePerDay,numberOfDays,season,discountType);
        System.out.printf("%.2f",priceCalculation.calculatePrice());

    }
}
