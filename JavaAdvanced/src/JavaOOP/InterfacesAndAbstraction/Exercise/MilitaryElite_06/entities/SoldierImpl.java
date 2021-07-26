package JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.entities;

import JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06.interfaces.Soldier;

public abstract class SoldierImpl implements Soldier {
    private int id;
    private String firstName;
    private String lastName;

    public SoldierImpl(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name: ")
                .append(this.firstName)
                .append(" ")
                .append(this.lastName)
                .append(" Id: ")
                .append(this.id);
        return builder.toString().trim();
    }
}
