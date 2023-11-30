package runanimal;

import java.util.Scanner;
public class RunAnimal {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter an animal (B for Bird, C for Cat, D for Dog, Q to quit): ");
            String animalType = scanner.nextLine();

            if (animalType.equalsIgnoreCase("Q")) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }
            Animal animal = null;

            switch (animalType.toUpperCase()) {
                case "B":
                    animal = new Bird();
                    break;
                case "C":
                    animal = new Cat();
                    break;
                case "D":
                    animal = new Dog();
                    break;
                default:
                    System.out.println("Invalid input. Please enter B, C, D, or Q to quit.");
                    continue;
            }
            animal.eat();
            animal.sleep();
            animal.makeSound();
        }

      
    }
}
