
package pokemon;

import java.util.Random;

class Steel extends Pokemon {
    public Steel(String name, String type) {
        super(name, type);
    }

    @Override
    public void listSkills() {
        System.out.println("1. Iron Bash");
        System.out.println("2. Steel Strike");
        System.out.println("3. Metal Claw");
    }

    
    public void attack(String skillName) {
        System.out.println(type + " type Pokemon " + name + " used " + skillName + "!");
        
       
        int minDamage = 0; 
        int maxDamage = 20; 
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

    

