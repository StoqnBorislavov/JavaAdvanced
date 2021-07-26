package JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.entities;

import JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.enums.Corps;
import JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.interfaces.Commando;
import JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.interfaces.Mission;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(this.missions);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString())
                .append(System.lineSeparator())
                .append("Corps: ");
        if (super.getCorps().equals(Corps.valueOf("MARINES"))) {
            builder.append("Marines");
        } else {
            builder.append("Airforces");
        }

        builder.append(System.lineSeparator())
                .append("Missions:")
                .append(System.lineSeparator());
        for (Mission m : missions) {
            builder.append("  ");
            builder.append(m.toString());
            builder.append(System.lineSeparator());
        }

        return builder.toString().trim();
    }

}
