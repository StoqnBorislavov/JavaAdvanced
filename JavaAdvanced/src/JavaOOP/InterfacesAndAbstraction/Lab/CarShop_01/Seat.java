package JavaOOP.InterfacesAndAbstraction.Lab.CarShop_01;

public class Seat extends CarImpl implements Car, Sellable{
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
