import java.util.*;

class BloodData{
    static String bloodType ="O";
    static String rhFactor ="+";

    public BloodData(){

    }

    public BloodData(String bt, String rh){
        bloodType = bt;
        rhFactor = rh;
    }
    public void display(){
        System.out.println(bloodType + rhFactor + " is added to the blood bank.");

    }
}
public class RunBloodData {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        while (true){
        System.out.print("Enter blood type (O, A, B, AB): ");
        String input1 = scan.nextLine();

        System.out.print("Enter Rhesus factor (+ or -): ");
        String input2 = scan.nextLine();

        BloodData bd;

        if (!input1.isEmpty() && !input2.isEmpty()){
            bd = new BloodData(input1, input2);
        }else {
            bd = new BloodData();
        }
        bd.display();
    }}
    
}
