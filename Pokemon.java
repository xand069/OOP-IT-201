package pokemon;

import java.util.Random;
import java.util.Scanner;

public class Pokemon {

    String name;
    String type;
    int health;
    int attack;
    int trainingCount = 0;
    int restCount = 0;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
        this.health = 100; 
        this.attack = 20; 
    }

    public void displayInfo() {
        System.out.println("\nThis is the stats of your Pokemon!");
        System.out.println("Name: " + name);
        System.out.println("Pokemon Type: " + type);
        System.out.println("Attack Power: " + attack);
        System.out.println("Health: " + health);
        System.out.println("Total Training Count: " + trainingCount);
        System.out.println("Total Rest Count: " + restCount);
    }

    public void train() {
        if (health > 0) {
            health -= 5;
            attack += 3;
            trainingCount++;
        } else {
            System.out.println("Your Pokemon fainted and cannot train.");
        }
    }

    public void attack(String skillName) {
        System.out.println(type + " type Pokemon " + name + " used " + skillName + "!");

       
        int damage = generateRandomDamage(skillName);
        System.out.println("Damage dealt: " + damage);
    }

    public void rest() {
        if (health < 100) {
            health += 3;
            restCount++;
            System.out.println("Your Pokemon is now resting.");
        } else {
            System.out.println("Your Pokemon is already fully rested.");
        }
    }

    
    private int generateRandomDamage(String skillName) {
        Random random = new Random();
        int baseDamage = 0;

        return baseDamage + (trainingCount * 2);
    }

    
    public void listSkills() {
        // Implement this in the subclasses
    }

    public String skillChoiceByName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose a skill by name:");
        listSkills();
        
    return scan.nextLine();
}
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\tGreetings Pokemon Trainer!\n--------------------------------------------");
        System.out.println("Select Type of a Pokemon \n 1. Steel \n 2. Dark \n 3. Poison");
        int choice = scan.nextInt();
        scan.nextLine(); // Consume the newline character

        String pokemonType = "";

        if (choice == 1) {
            pokemonType = "Steel";
        } else if (choice == 2) {
            pokemonType = "Dark";
        } else if (choice == 3) {
            pokemonType = "Poison";
        } else {
            System.out.println("Invalid choice. Please select a valid Pokemon type.");
            System.exit(0);
        }

        System.out.println("Enter the name of your Pokemon:");
        String pokemonName = scan.nextLine();

        
        Pokemon selectedPokemon = null;
        if ("Steel".equals(pokemonType)) {
            selectedPokemon = new Steel(pokemonName, pokemonType);
        } else if ("Dark".equals(pokemonType)) {
            selectedPokemon = new Dark(pokemonName, pokemonType);
        } else if ("Poison".equals(pokemonType)) {
            selectedPokemon = new Poison(pokemonName, pokemonType);
        }

        if (selectedPokemon != null) {
            System.out.println("\nCongratulations! You have chosen " + pokemonName + ", a " + pokemonType + " type of Pokemon");

            selectedPokemon.displayInfo();

            while (true) {
                System.out.println("\nWhat do you want to do with your Pokemon?");
                System.out.println("1. Train");
                System.out.println("2. Rest");
                System.out.println("3. Attack");
                System.out.println("4. Display Stats");
                System.out.println("5. Exit");

                int option = scan.nextInt();
                scan.nextLine(); 

                if (option == 1) {
                    selectedPokemon.train();
                } else if (option == 2) {
                    selectedPokemon.rest();
                } else if (option == 3) {
                    String skillName = selectedPokemon.skillChoiceByName();
                    selectedPokemon.attack(skillName);
                } else if (option == 4) {
                    selectedPokemon.displayInfo();
                } else if (option == 5) {
                    System.out.println("Goodbye, Pokemon Trainer!");
                    break;
                } else {
                    System.out.println("Invalid option. Please select a valid option.");
                }
            }
        }
    }
}