package HotelReservation;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input=scan.nextLine().split("\\s+");
        double pricePerDay=Double.parseDouble(input[0]);
        int numberOfDays=Integer.parseInt(input[1]);
        String season= input[2];
        PriceCalculator priceCalculation;
        if (input.length>3){
            String discountType= input[3];
            priceCalculation=new PriceCalculator(pricePerDay,numberOfDays,season,discountType);
        }else{
            priceCalculation=new PriceCalculator(pricePerDay,numberOfDays,season);
        }
        System.out.println(priceCalculation.price());

    }
}
