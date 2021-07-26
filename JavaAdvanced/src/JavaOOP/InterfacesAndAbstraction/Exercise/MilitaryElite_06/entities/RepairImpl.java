package JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.entities;

import JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.interfaces.Repair;

public class RepairImpl implements Repair {
    private String partName;
    private int hoursWorked;

    public RepairImpl(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Part Name: ")
                .append(this.partName)
                .append(" Hours Worked: ")
                .append(this.hoursWorked);

        return builder.toString().trim();
    }
}
