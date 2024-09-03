package labprogram;

import java.util.ArrayList;
import java.util.List;

class Fruit {
    public void displayInfo() {
        System.out.println("I am a fruit.");
    }
}

class Apple extends Fruit {
    @Override
    public void displayInfo() {
        System.out.println("I am an apple.");
    }
}

class Orange extends Fruit {
    @Override
    public void displayInfo() {
        System.out.println("I am an orange.");
    }
}

public class main4 {
    // Method to print a list of fruits using wildcard argument
    public static void printFruits(List<? extends Fruit> fruits) {
        for (Fruit fruit : fruits) {
            fruit.displayInfo();
        }
    }

    public static void main(String[] args) {
        List<Fruit> fruitList = new ArrayList<>();
        fruitList.add(new Fruit());
        fruitList.add(new Apple());
        fruitList.add(new Orange());

        List<Apple> appleList = new ArrayList<>();
        appleList.add(new Apple());
        appleList.add(new Apple());

        System.out.println("Printing fruits using wildcard:");
        printFruits(fruitList);

        System.out.println("\nPrinting apples using wildcard:");
        printFruits(appleList);
    }
}

