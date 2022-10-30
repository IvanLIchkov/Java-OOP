package MilitaryElite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command= scan.nextLine();
        List<SoliderImpl> soliders=new ArrayList<>();
        while (!command.equals("End")){
            String[]commands=command.split("\\s+");
            String rank= commands[0];
            int id=Integer.parseInt(commands[1]);
            String firstName=commands[2];
            String lastName=commands[3];
                switch (rank) {
                    case "Private":
                        double salary = Double.parseDouble(commands[4]);
                        Private privateS = new Private(id, firstName, lastName, salary);
                        soliders.add(privateS);
                        break;
                    case "LieutenantGeneral":
                        salary = Double.parseDouble(commands[4]);
                        LieutenantGeneral lieutenantGeneral = new LieutenantGeneral(id, firstName, lastName, salary);
                        for (int i = 5; i < commands.length; i++) {
                            id = Integer.parseInt(commands[i]);
                            int tempId = id;
                            soliders.stream().filter(s -> s instanceof Private)
                                    .map(s -> (Private) s)
                                    .filter(p -> p.getId() == tempId)
                                    .forEach(lieutenantGeneral::addPrivate);
                        }
                        soliders.add(lieutenantGeneral);
                        break;
                    case "Engineer":
                        salary = Double.parseDouble(commands[4]);
                        String corp = commands[5];
                        try {
                            Engineer engineer = new Engineer(id, firstName, lastName, salary, corp);
                            for (int i = 6; i < commands.length - 1; i += 2) {
                                int hours = Integer.parseInt(commands[i + 1]);
                                String part = commands[i];
                                Repair repair = new Repair(part, hours);
                                engineer.addRepair(repair);
                            }
                            soliders.add(engineer);
                        }catch (IllegalArgumentException e){

                        }
                        break;
                    case "Commando":
                        salary = Double.parseDouble(commands[4]);
                        corp = commands[5];
                        List<Mission> missions = new ArrayList<>();
                        for (int i = 6; i < commands.length - 1; i += 2) {
                            String codeName = commands[i];
                            String state = commands[i + 1];
                            try {
                                missions.add(new Mission(codeName, state));
                            }catch (IllegalArgumentException e){

                            }
                        }
                        Commando commando = new Commando(id, firstName, lastName, salary, corp, missions);
                        soliders.add(commando);
                        break;
                    case "Spy":
                        String codeNumber = commands[4];
                        soliders.add(new Spy(id, firstName, lastName, codeNumber));
                        break;
                }
            command = scan.nextLine();
        }
        for (SoliderImpl solider : soliders) {
            System.out.print(solider.toString());
        }

    }
}
