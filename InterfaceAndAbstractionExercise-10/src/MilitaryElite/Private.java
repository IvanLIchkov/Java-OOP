package MilitaryElite;

public class Private extends SoliderImpl implements PrivateInt{
    private double salary;

    public Private(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }
    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d Salary: %.2f%n",getFirstname(),getLastName(),getId(),getSalary());
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
