package JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.interfaces;

import java.util.Collection;

public interface Commando extends  Soldier {
    void addMission(Mission mission);
    Collection<Mission> getMissions();

}
