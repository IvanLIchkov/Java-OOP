package hero;

public class DarkKnight extends Knight{
    public DarkKnight(String username, int level) {
        super(username, level);
    }
    @Override
    public String toString() {
        return String.format("Type: %s Username: %s Level: %s",
                this.getClass().getName(),
                this.getUsername(),
                this.getLevel());
    }

}
