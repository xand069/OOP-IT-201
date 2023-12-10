import java.time.LocalTime;
import java.util.Scanner;

interface Alarm {
    void setAlarm(String time);
    void showAlarm();
}

abstract class Weekday implements Alarm {
     String time;

    public void setAlarm(String time) {
        this.time = time;
    }
}

public class Monday extends Weekday {
    public static void main(String[] args) {
            Weekday weekday = new Monday();
    
            Scanner input = new Scanner(System.in);
            System.out.print("Enter time for alarm in this format (HH:MM): ");
            weekday.setAlarm(input.next());
            weekday.showAlarm();
        
    }

    public void showAlarm() {
        LocalTime alarm = LocalTime.parse(this.time);
        LocalTime now = LocalTime.now();
        if (alarm.isAfter(now)) {
            System.out.println("Alarm is set for tomorrow!");
        } else {
            System.out.println("I'll wake you up later!");
        }
    }
}