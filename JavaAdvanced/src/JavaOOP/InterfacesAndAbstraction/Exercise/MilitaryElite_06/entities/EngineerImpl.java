package JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.entities;

import JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.enums.Corps;
import JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.interfaces.Engineer;
import JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.interfaces.Repair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return Collections.unmodifiableCollection(this.repairs);
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
                .append("Repairs:")
                .append(System.lineSeparator());
        for (Repair r : repairs) {
            builder.append("  ");
            builder.append(r.toString());
            builder.append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
