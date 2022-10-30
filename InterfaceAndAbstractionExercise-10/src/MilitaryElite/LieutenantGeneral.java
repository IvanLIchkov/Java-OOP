package MilitaryElite;

import java.util.*;
import java.util.stream.Collectors;

public class LieutenantGeneral extends Private {
    private List<Private> privates;

    public LieutenantGeneral(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    public void addPrivate(Private priv) {
        privates.add(priv);
    }
    public Private getPrivate(int privateId){
        return privates.stream().filter(p->p.getId()==privateId).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        StringBuilder output=new StringBuilder(String.format("Name: %s %s Id: %d Salary: %.2f%nPrivates:%n",getFirstname(),getLastName(),getId(),getSalary()));
        privates= privates.stream().sorted(Comparator.comparing(Private::getId)).collect(Collectors.toList());
        Collections.reverse(privates);
        for (Private aPrivate : privates) {
            output.append(" "+aPrivate.toString());
        }
        return String.valueOf(output);
    }
}
