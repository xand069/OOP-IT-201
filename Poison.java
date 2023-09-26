
package pokemon;

import java.util.Random;

public class Poison extends Pokemon {
    public Poison(String name, String type) {    
    super(name, type);
    }

    public void listSkills() {
        
        System.out.println("1. Poison Sting");
        System.out.println("2. Toxic Spray");
        System.out.println("3. Acid Spit");
    }

    
    public void attack(String skillName) {
        System.out.println(type + " type Pokemon " + name + " used " + skillName + "!");
        
        int minDamage = 15; 
        int maxDamage = 25; 
        int damage = new Random().nextInt(maxDamage - minDamage + 1) + minDamage;
        
        
        int totalDamage = damage + (trainingCount * 2);
        
        System.out.println("Damage dealt: " + totalDamage);
    }
 
    public void train() {
        if (health > 0) {
            health -= 5;
            attack += 3;
            trainingCount++;
            System.out.println("Training complete! Your Pokemon's attack power increased.");
        } else {
            System.out.println("Your Pokemon fainted and cannot train.");
        }
    }
}