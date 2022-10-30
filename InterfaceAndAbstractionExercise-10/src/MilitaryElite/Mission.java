package MilitaryElite;

public class Mission {
    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        setState(state);
    }

    public void setState(String state) {
            MissionState missionState=MissionState.validateMission(state);
            this.state=state;
    }

    @Override
    public String toString() {
        return String.format(" Code Name: %s State: %s",codeName,state);
    }
}
