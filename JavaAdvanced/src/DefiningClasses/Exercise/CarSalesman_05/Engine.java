package DefiningClasses.Exercise.CarSalesman_05;

import java.util.Map;

public class Engine {
    private String engineModel;
    private int power;
    private int displacement;
    private String efficiency;


    public Engine(String engineModel, int power){
        this(engineModel, power, -1, "n/a");
    }

    public Engine(String engineModel, int power, String efficiency){
        this(engineModel, power, -1, efficiency);
    }

    public Engine(String engineModel, int power, int displacement){
        this(engineModel, power, displacement, "n/a");
    }
    public Engine(String engineModel, int power, int displacement, String efficiency) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }
//    V4-33:
//    Power: 140
//    Displacement: 28
//    Efficiency: B



    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.engineModel).append(":").append("\n");
        stringBuilder.append("Power: ").append(this.power).append("\n");
        if(this.displacement == -1){
            stringBuilder.append("Displacement: ").append("n/a").append("\n");
        }else {
            stringBuilder.append("Displacement: ").append(this.displacement).append("\n");
        }
        stringBuilder.append("Efficiency: ").append(this.efficiency);

        return stringBuilder.toString();
    }
}
