//==========================================================================================
// PROGRAMMER: Giorgio Abboud
// PANTHER ID: 6360563
//
// CLASS: COP2210
// SECTION: U01
// SEMESTER: Spring 2023
// CLASSTIME: T/TH 9:30 am - 12:15 pm
//
// Project: Lab 10
// DUE: April 9 2023
//
// CERTIFICATION: I understand FIU’s academic policies, and I certify that this work is my
//                own and that none of it is the work of any other person.
//==========================================================================================

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    //-----------------------------------------------------------------
    // beginning of main(String[] args)) method

    public static void main(String[] args) throws Exception{

        yourInfoHeader();

        //-----------------------------------------------------------------
        //-----------------------------------------------------------------

        System.out.println();

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Data.txt output");
        System.out.println("=========================================");

        try {

            String fileLocation = "./Data/data.txt";

            BufferedReader br = new BufferedReader(new FileReader("./Data/data.txt"));
            String line;

            String strCurrentLine;

            while ((strCurrentLine = br.readLine()) != null){
                System.out.println(strCurrentLine);
            }

        }catch (IOException e){

            e.printStackTrace();

        }

        //-----------------------------------------------------------------
        //-----------------------------------------------------------------

        ArrayList<Car> cars = new ArrayList<Car>();
        ArrayList<Human> humans = new ArrayList<Human>();
        ArrayList<Fruit> fruits = new ArrayList<Fruit>();
        ArrayList<Bowl> bowls = new ArrayList<Bowl>();

        try{

            BufferedReader br =  new BufferedReader(new FileReader("./Data/data.txt"));

            String line;

            String strCurrentLine;

            while((strCurrentLine = br.readLine()) != null){

                String[] tokens = strCurrentLine.split(",");

                if(tokens[0].equals("Car")){
                    Car car = new Car(tokens[1], tokens[2], tokens[3]);
                    cars.add(car);
                }

                else if(tokens[0].equals("Human")){
                    if(tokens.length > 2){
                        Car carHuman = new Car(tokens[4], tokens[5], tokens[6]);
                        Human human = new Human(carHuman, tokens[1]);
                        humans.add(human);
                        cars.add(carHuman);
                    }else{
                        Human human = new Human(tokens[1]);
                        humans.add(human);
                    }
                }

                else if(tokens[0].equals("Fruit")){
                    Fruit fruit = new Fruit(tokens[1], tokens[2]);
                    fruits.add(fruit);
                }

                else if(tokens[0].equals("Bowl")){

                    ArrayList<Fruit> fruitsFromBowl = new ArrayList<>();
                    if(tokens.length > 3){
                        for(int i = 5; i <= tokens.length; i+=3){
                            Fruit fruitBowl = new Fruit(tokens[i], tokens[i+1]);
                            fruitsFromBowl.add(fruitBowl);
                            fruits.add(fruitBowl);
                        }// end for
                        Bowl bowl = new Bowl(fruitsFromBowl, tokens[1], tokens[2]);
                        bowls.add(bowl);
                    }else{
                        Bowl bowl = new Bowl(fruitsFromBowl, tokens[1], tokens[2]);
                        bowls.add(bowl);
                    }
                }

            }// end while loop

        }catch (IOException e){

            e.printStackTrace();

        }

        //-----------------------------------------------------------------
        //-----------------------------------------------------------------

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Car List");
        System.out.println("=========================================");

        for(Car car: cars){
            ((Car) car).displayInfo();
        }

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Human List");
        System.out.println("=========================================");

        for(Human human: humans){
            ((Human) human).displayInfo();
        }

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Fruit List");
        System.out.println("=========================================");

        for(Fruit fruit: fruits){
            ((Fruit) fruit).displayInfo();
        }

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Bowl List");
        System.out.println("=========================================");

        for(Bowl bowl: bowls){
            ((Bowl) bowl).displayInfo();
        }

        findYoungestHumanWithoutCar(humans);

        findOldestHumanWithCar(humans);

        bowlWithMostFruitWeight(bowls);

    }//end main

    //-----------------------------------------------------------------
    //-----------------------------------------------------------------

    public static Human findYoungestHumanWithoutCar(ArrayList<Human> humans) {

        int youngest = humans.get(0).getAge();
        Human youngestHuman = null;

        for (Human human : humans) {
            if ((human.getAge() < youngest) && (human.getCar() == null)) {
                youngest = human.getAge();
                youngestHuman = human;
            }
        }
        
        System.out.println();
        System.out.println("=========================================");
        System.out.println("Youngest Human Without Car");
        System.out.println("=========================================");

        assert youngestHuman != null;
        youngestHuman.displayInfo();

        System.out.println();
        return youngestHuman;
    }
    
    public static Human findOldestHumanWithCar(ArrayList<Human> humans){

        int oldest = humans.get(0).getAge();
        Human oldestHuman = null;

        for (Human human : humans) {
            if ((human.getAge() > oldest) && (human.getCar() != null)) {
                oldest = human.getAge();
                oldestHuman = human;
            }
        }

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Oldest Human With Car");
        System.out.println("=========================================");

        assert oldestHuman != null;
        oldestHuman.displayInfo();

        System.out.println();
        return oldestHuman;
    }

    public static Bowl bowlWithMostFruitWeight(ArrayList<Bowl> bowls) {

        double heaviestBowlWeight = 0.0;
        double fruitWeight = 0.0;
        Bowl heavyBowl = null;

        for(Bowl bowl: bowls){
            for(Fruit fruit: bowl.getFruits()){
                fruitWeight += fruit.getWeight();
            }
            if((fruitWeight > heaviestBowlWeight) && bowl.getSize() != 0){
                heaviestBowlWeight = fruitWeight;
                heavyBowl = bowl;
            }
            fruitWeight = 0.0;
        }

        System.out.println();
        System.out.println("=========================================");
        System.out.println("Bowl with the most fruit by weight");
        System.out.println("=========================================");

        assert heavyBowl != null;
        heavyBowl.displayInfo();

        System.out.println();
        return heavyBowl;
    }

    //-----------------------------------------------------------------
    // beginning of yourInfoHeader() method

    public static void yourInfoHeader() {

        System.out.println("============================================");
        System.out.println("PROGRAMMER:  " + "Giorgio Abboud");
        System.out.println("PANTHER ID:  " + "6360563");
        System.out.println();
        System.out.println("CLASS: \t\t COP 2210 ");
        System.out.println("SECTION: \t " + "U01");
        System.out.println("SEMESTER: \t " + "Spring");
        System.out.println("CLASSTIME: \t " + "9:30 am to 12:15 pm");
        System.out.println();
        System.out.println("Assignment: " + "Lab 10");
        System.out.println();
        System.out.println("CERTIFICATION: \nI understand FIU's academic policies, and I certify");
        System.out.println("that this work is my own and that none of it is the");
        System.out.println("work of any other person.");
        System.out.println("============================================");
        System.out.println();

    }// end yourInfoHeader

}//end Controller
