package BorderControl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command= scan.nextLine();
        List<Identifiable> names=new ArrayList<>();
        while (!command.equals("End")){
            String[] commands=command.split("\\s+");
            String name=commands[0];
            if (commands.length==3){
                int age=Integer.parseInt(commands[1]);
                String id=commands[2];
                Identifiable citizen=new Citizen(name,age,id);
                names.add(citizen);
            }else{
                String id= commands[1];
                Identifiable robot=new Robot(name,id);
                names.add(robot);
            }
            command= scan.nextLine();
        }
        String end= scan.nextLine();
        names.stream()
                .map(Identifiable::getId)
                .filter(e->e.endsWith(end))
                .forEach(System.out::println);
    }
}
