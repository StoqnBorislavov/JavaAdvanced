public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;


    public Dough(String flourType, String bakingTechnique, double weight){
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if(flourType.equals("White") || flourType.equals("Wholegrain")) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
//        •	Crispy – 0.9;
//        •	Chewy – 1.1;
//        •	Homemade – 1.0;
        switch (bakingTechnique){
            case "Crispy":
            case "Chewy":
            case "Homemade":
                this.bakingTechnique = bakingTechnique;
                break;
            default:
                throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    private void setWeight(double weight) {
        if(weight >= 1 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }

    }

    public double calculateCalories(){
        double flourTypeModificator = this.getFlourTypeModificator(this.flourType) ;
        double bakingTechniqueModificator = this.getBakingTechniqueModificator(this.bakingTechnique);
        return 2 * this.weight * flourTypeModificator * bakingTechniqueModificator;
    }

    private double getBakingTechniqueModificator(String bakingTechnique) {
        if(bakingTechnique.equals("Crispy")){
            return 0.9;
        } else if(bakingTechnique.equals("Chewy")){
            return 1.1;
        } else if(bakingTechnique.equals("Homemade")){
            return 1.0;
        }
        return 0;

    }

    private double getFlourTypeModificator(String flourType) {
        if(flourType.equals("White")){
            return  1.5;
        }else if (flourType.equals("Wholegrain")){
            return 1.0;
        }
        return 0;
    }
}
