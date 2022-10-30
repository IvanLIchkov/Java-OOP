package MilitaryElite;

import java.util.Collection;
import java.util.List;

public class Commando extends SpecialisedSoldier implements CommandoInt {
    private List<Mission>missions;

    public Commando(int id, String firstName, String lastName, double salary, String corps, List<Mission> missions) {
        super(id, firstName, lastName, salary, corps);
        this.missions = missions;
    }
    public void addMission(Mission mission){
        missions.add(mission);
    }

    @Override
    public String toString() {
        StringBuilder output=new StringBuilder(super.toString());
            output.append("Missions:").append(System.lineSeparator());
        for (Mission mission : missions) {
            output.append(" "+mission.toString()).append(System.lineSeparator());
        }
        return String.valueOf(output);
    }

    @Override
    public List<Mission> getMissions() {
        return missions;
    }
}
