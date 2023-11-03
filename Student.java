/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package student;

  import java.util.*;
public class Student {

    private String name;
    private String section;
    private double gwa;

    public Student(String name, String section, double gwa){
        this.name = name;
        this.section = section;
        this.gwa = gwa;
    }

    public String getName(){
        return name;
    }

    public String getSection(){
        return section;
    }

    public double getGwa(){
        return gwa;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSection(String section){
        this.section = section;
    }

    public void setGwa(double gwa){
        this.gwa = gwa;
    }
}


public class StudenInfo {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[10];
        int studentCount = 0;

        boolean stu = true;  

        while (stu) {
            
            System.out.println("========Student Registration========");
            System.out.println("1. Add Students");
            System.out.println("2. Edit Students");
            System.out.println("3. View Students");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1 ){

                if (studentCount < 10) {
                    System.out.println("Enter student's name, section, and GWA separated by space: ");
                    String[] inputParts = sc.nextLine().split(" ");

                    if (inputParts.length == 3) {
                        students[studentCount] = new Student(inputParts[0], inputParts[1], Double.parseDouble(inputParts[2]));
                        studentCount++;
                        System.out.println("Student added successfully!");

                    } else {
                        System.out.println("Invalid input format. Please enter name, section, and GWA separated by spaces.");
                    }

                } else {
                    System.out.println("The maximum limit of students (10) has been reached.");
                }

            } else if (choice == 2) {
                System.out.println("Enter the name of the student you want to edit:");
                String studentToEdit = sc.nextLine();
                boolean studentFound = false;

                for (int i = 0; i < studentCount; i++) {

                    if (students[i].getName().equalsIgnoreCase(studentToEdit)) {
                        System.out.println("Enter the new name for the student:");
                        students[i].setName(sc.nextLine());
                        System.out.println("Enter the new section for the student:");
                        students[i].setSection(sc.nextLine());
                        System.out.println("Enter the new GWA for the student:");
                        students[i].setGwa(Double.parseDouble(sc.nextLine()));
                        System.out.println("Student information updated.");
                        studentFound = true;
                        break;
                    }
                }

             if (!studentFound) {
                    System.out.println("Student not found. Please enter a valid name.");
                }

            } else if (choice == 3) {

                if (studentCount > 0) {
                    System.out.println("List of students:");

                    for (int i = 0; i < studentCount; i++) {
                        System.out.println((i + 1) + ". Name: " + students[i].getName() + ", Section: " + students[i].getSection() + ", GWA: " + students[i].getGwa());
                    }

                } else {
                    System.out.println("No students to view.");
                }

            } else if (choice == 4) {
                System.out.println("Exiting program.");
                stu = false;

            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}