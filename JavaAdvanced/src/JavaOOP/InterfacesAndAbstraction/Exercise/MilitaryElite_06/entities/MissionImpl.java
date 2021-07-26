package JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.entities;

import JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.interfaces.Mission;

public class MissionImpl implements Mission {

    public enum Status{
        INPROGRESS,
        FINISHED;
    }
    private String codeName;
    private Status status;
    public MissionImpl(String codeName, Status status) {
        this.codeName = codeName;
        this.status = status;
    }

    @Override
    public void completeMission() {
        this.status = Status.FINISHED;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Code Name: ")
                .append(this.codeName)
                .append(" ")
                .append("State: ");
        if(this.status.equals(Status.valueOf("INPROGRESS"))){
            builder.append("inProgress");
        } else {
            builder.append("finished");
        }

        return builder.toString().trim();
    }

}
