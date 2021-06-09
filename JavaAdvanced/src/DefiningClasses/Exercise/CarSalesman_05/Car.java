package DefiningClasses.Exercise.CarSalesman_05;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;


    public Car(String model, Engine engine){
        this(model, engine,-1, "n/a");
    }

    public Car(String model, Engine engine, String color){
        this(model, engine,-1, color);
    }

    public Car(String model, Engine engine, int weight){
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }
//    FordFocus:
//    V4-33:
//    Power: 140
//    Displacement: 28
//    Efficiency: B
//    Weight: 1300
//    Color: Silver
//    FordMustang:


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.model).append(":").append("\n");
        stringBuilder.append(this.engine).append("\n");
        if(this.weight == -1){
            stringBuilder.append("Weight: ").append("n/a").append("\n");
        }else {
            stringBuilder.append("Weight: ").append(this.weight).append("\n");
        }
        stringBuilder.append("Color: ").append(this.color).append("\n");

        return stringBuilder.toString();
    }


}
