package JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.interfaces;

import java.util.Collection;

public interface Engineer extends Soldier {
    void addRepair(Repair repair);
    Collection<Repair> getRepairs();

}
