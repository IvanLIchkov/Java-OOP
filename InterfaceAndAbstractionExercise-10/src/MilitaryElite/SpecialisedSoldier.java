package MilitaryElite;

public class SpecialisedSoldier extends Private implements  SpecializedInt{
    private String corps;

    public SpecialisedSoldier(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        setCorps(corps);
    }

    public String getCorps() {
        return corps;
    }

    private void setCorps(String corps) {
            Corps corps1=Corps.validateCorp(corps);
            this.corps=corps;
    }

    @Override
    public String toString() {
        StringBuilder output=new StringBuilder(String.format("Name: %s %s Id: %d Salary: %.2f%nCorps: %s%n",getFirstname(),getLastName(),getId(),getSalary(),getCorps()));
        return String.valueOf(output);
    }

    @Override
    public String getCorp() {
        return corps;
    }
}
