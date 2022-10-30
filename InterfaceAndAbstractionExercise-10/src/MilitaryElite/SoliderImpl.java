package MilitaryElite;

public class SoliderImpl implements Getbale {
    private int id;
    private String firstName;
    private String lastName;

    public SoliderImpl(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getFirstname() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public int getId() {
        return id;
    }
}
