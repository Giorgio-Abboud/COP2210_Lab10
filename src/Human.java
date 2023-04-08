public class Human {

    private int age;
    private Car car;


    public Human(String age){
        this.age = Integer.parseInt(age);
    }

    public Human(Car car, String age){
        this.age = Integer.parseInt(age);
        this.car = car;
    }

    public Car getCar(){
        return car;
    }

    public void setCar(){
        this.car = car;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void displayInfo(){
        if(car == null){
            System.out.printf("Type->Human-> Age: %s\n", age);
        }else{
            System.out.printf("Type->Human-> Age: %s\n", age);
            System.out.printf("\t\tType->Car-> Price: $%s \t\t Color: %s \t Doors: %s\n", car.getPrice(), car.getColor(), getCar().getNumberOfDoors());
        }
    }
}
