import java.util.ArrayList;

public class Bowl {

    private ArrayList<Fruit> fruits;
    private String color;
    private int size;


    public Bowl(ArrayList<Fruit> fruits, String color, String size){
        this.color = color;
        this.size = Integer.parseInt(size);
        this.fruits = fruits;
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void displayInfo(){
        if(fruits.size() == 0){
            System.out.printf("Type->Bowl-> Color: %s \t\t\t Size: %s\n", color, size);
        }else{
            System.out.printf("Type->Bowl-> Color: %s \t\t\t Size: %s\n", color, size);
            for(Fruit fruit: fruits){
                System.out.printf("\t\t\tType->Fruit-> Type: %s \t\t Weight: %s\n", fruit.getType(), fruit.getWeight());
            }
        }
    }
}
