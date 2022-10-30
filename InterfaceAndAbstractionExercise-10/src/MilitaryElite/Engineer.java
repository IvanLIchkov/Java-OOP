package MilitaryElite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Engineer extends SpecialisedSoldier implements EngineerInt {
    private List<Repair> repairs;

    public Engineer(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    public void addRepair(Repair repair) {
        repairs.add(repair);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString());
        output.append("Repairs:").append(System.lineSeparator());
        for (Repair repair : repairs) {
            output.append(" " + repair.toString()).append(System.lineSeparator());
        }
        return String.valueOf(output);
    }

    @Override
    public List<Repair> getRepairs() {
        return repairs;
    }
}
