package JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.entities;

import JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.interfaces.LieutenantGeneral;
import JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.interfaces.Private;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private List<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString())
        .append(System.lineSeparator());
        Collections.sort(privates, (f, s) -> Integer.compare(s.getId(), f.getId()));
        for (Private p : privates) {
            builder.append("  ");
            builder.append(p.toString());
            builder.append(System.lineSeparator());
        }

        return builder.toString().trim();
    }
}
