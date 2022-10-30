package FoodShortage;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
        int numberOfPeople=Integer.parseInt(scan.nextLine());
        List<Buyer> buyers=new ArrayList<>();
        for (int i = 0; i < numberOfPeople; i++) {
            String[] tokens=scan.nextLine().split("\\s+");
            String name=tokens[0];
            int age=Integer.parseInt(tokens[1]);
            if (tokens.length==4){
                String id=tokens[2];
                String dateOfBirth=tokens[3];
                Buyer citizen=new Citizen(name,age,id,dateOfBirth);
                buyers.add(citizen);
            }else{
                String group=tokens[2];
                Buyer rebel=new Rebel(name,age,group);
                buyers.add(rebel);
            }
        }
        String buyer= scan.nextLine();
        while (!buyer.equals("End")){
            String buyerName=buyer;
            buyers.stream()
                    .filter(b->b.getName().equals(buyerName))
                    .forEach(Buyer::buyFood);
            buyer= scan.nextLine();
        }
        System.out.println(buyers.stream()
                .map(Buyer::getFood)
                .mapToInt(Integer::intValue)
                .sum());


    }
}
