package MilitaryElite;

public class Spy extends SoliderImpl implements SpyInt{
    private String codeNumber;

    public Spy(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d%n" +
                "Code Number: %s%n",getFirstname(),getLastName(),getId(),getCodeNumber());
    }

    @Override
    public String getCodeNumber() {
        return codeNumber;
    }
}
