package JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.entities;

import JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.enums.Corps;
import JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    protected Corps getCorps() {
        return corps;
    }
}
