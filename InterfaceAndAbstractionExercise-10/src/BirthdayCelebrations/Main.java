package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command= scan.nextLine();
        List<Birthable> people=new ArrayList<>();
        while (!command.equals("End")){
            String[] commands=command.split("\\s+");
            String typeOfGuy=commands[0];
            String name= commands[1];
            switch (typeOfGuy){
                case "Citizen":
                    int age=Integer.parseInt(commands[2]);
                    String id=commands[3];
                    String dateOfBirth=commands[4];
                    Birthable citizen=new Citizen(name,age,id,dateOfBirth);
                    people.add(citizen);
                    break;
                case "Pet":
                    String birthDte=commands[2];
                    Birthable pet=new Pet(name,birthDte);
                    people.add(pet);
                    break;
                case "Robot":
                    break;
            }
            command= scan.nextLine();
        }
        List<String> dates=new ArrayList<>();
        String endString= scan.nextLine();
        people.stream().map(Birthable::getBirthDate)
                .filter(bD->bD.endsWith(endString))
                .forEach(dates::add);
        if (dates.size()==0){
            System.out.println("<no output>");
        }else{
            dates.forEach(System.out::println);
        }
    }
}
