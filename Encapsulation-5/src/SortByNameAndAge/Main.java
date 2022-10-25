package SortByNameAndAge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scan.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = scan.nextLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);

            Person personToAdd = new Person(firstName, lastName, age, salary);
            people.add(personToAdd);
        }
//        double bonus=Double.parseDouble(scan.nextLine());
        Team team = new Team("Black Eagles");
        for (Person person : people) {
            team.addPlayer(person);
        }
//        for (Person person : people) {  TODO: the list are immutable in getList method in class person, that's why they can't be changed.
//            if (person.getAge() < 40) {
//                team.getFirstTeam().add(person);
//            } else {
//                team.getReservedTeam().add(person);
//            }
//        }
        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + team.getReservedTeam().size() + " players");
    }
}
