package DefiningClasses.Lab;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public  void setBrand(String brand){
        this.brand = brand;
    }
    public String getBrand (){
        return brand;
    }

    public void setHorsePower(int horsePower) {
        if(horsePower < 0){
            horsePower = 0;
        }
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Car) {
            Car other = (Car) obj;
            return this.brand.equals(other.brand)
                    && this.model.equals(other.model)
                    && this.horsePower == other.horsePower;
        };
        return false;
    }

    @Override
    public String toString(){
        return String.format("The car is: %s %s - %d HP.",
                this.getBrand(), this.getModel(), this.getHorsePower());
    }
}
