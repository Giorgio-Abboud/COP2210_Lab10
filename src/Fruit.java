public class Fruit {

    private String type;
    private double weight;


    public Fruit(String type, String weight){
        this.type = type;
        this.weight = Double.parseDouble(weight);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void displayInfo(){
        System.out.printf("Type->Fruit-> Type: %s \t\t\t Weight: %s\n", type, weight);
    }
}
