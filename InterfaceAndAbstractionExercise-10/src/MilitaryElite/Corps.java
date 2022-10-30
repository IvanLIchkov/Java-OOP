package MilitaryElite;

public enum Corps {
    AIR_FORCES("Airforces"),
    MARINES("Marines");

    private String marines;

    private Corps(String marines) {
        this.marines=marines;
    }

    public String validateCorp() {
        return marines;
    }

    public static Corps validateCorp(String marine){
        switch (marine){
            case "Airforces":
                return AIR_FORCES;
            case "Marines":
                return MARINES;
            default:
                throw new IllegalArgumentException("Unknown corp");
        }
    }
}
