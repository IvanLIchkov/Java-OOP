package MilitaryElite;

public enum MissionState {
    IN_PROGRESS("inProgress"),
    FINISHED("finished");
    private String mission;

    MissionState(String mission) {
        this.mission = mission;
    }

    public static MissionState validateMission(String m){
        switch (m){
            case "inProgress":
                return IN_PROGRESS;
            case "finished":
                return FINISHED;
            default:
                throw new IllegalArgumentException("Unknown state of mission");
        }
    }
}
