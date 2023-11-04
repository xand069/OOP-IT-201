package liststudents;

import java.util.Scanner;

public class ListStudents {
     public static void main(String[] args) {
        Student[] students = new Student[10];
        Scanner scanner = new Scanner(System.in);

        int choice;
        int studentCount = 0;

        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add a student");
            System.out.println("2. Edit a student");
            System.out.println("3. View the list of students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    if (studentCount < 10) {
                        Student newStudent = addStudent(scanner);
                        if (newStudent != null) {
                            students[studentCount] = newStudent;
                            studentCount++;
                        }
                    } else {
                        System.out.println("You have already exceeded the limit of 10 students.");
                    }
                    break;
                case 2:
                    editStudent(students, scanner);
                    break;
                case 3:
                    viewStudents(students);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static Student addStudent(Scanner scanner) {
    System.out.print("Enter the student's name or press Enter to skip: ");
    String name = scanner.nextLine();

    System.out.print("Enter the student's course or press Enter to skip: ");
    String course = scanner.nextLine();

    System.out.print("Enter the student's GWA or press Enter to skip: ");
    String gwaInput = scanner.nextLine();

    // Initialize with default values
    String defaultName = "N/A";
    String defaultCourse = "N/A";
    double defaultGWA = -1.0;

    if (name.isEmpty()) {
        name = defaultName;
    }

    if (course.isEmpty()) {
        course = defaultCourse;
    }

    if (gwaInput.isEmpty()) {
        return new Student(name, course, defaultGWA); // Create a student with default values.
    } else {
        try {
            double gwa = Double.parseDouble(gwaInput);
            return new Student(name, course, gwa);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. The student will be recorded with default values.");
            return new Student(name, course, defaultGWA); // Create a student with default values in case of invalid input.
        }
    }
}

    public static void editStudent(Student[] students, Scanner scanner) {
        System.out.print("Enter the index of the student you want to edit (1-" + students.length + "): ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (index >= 1 && index <= students.length) {
            Student editedStudent = addStudent(scanner);
            if (editedStudent != null) {
                students[index - 1] = editedStudent;
                System.out.println("Student at index " + index + " has been updated.");
            } else {
                System.out.println("Edit canceled. Student information remains unchanged.");
            }
        } else {
            System.out.println("Invalid index. Please enter a number between 1 and " + students.length + " for an existing student.");
        }
    }

    public static void viewStudents(Student[] students) {
        System.out.println("List of Students:");
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                System.out.println((i + 1) + ". " + students[i]);
            }
        }
    }
}

class Student {
    private String name;
    private String course;
    private double gwa;

    public Student(String name, String course, double gwa) {
        this.name = name;
        this.course = course;
        this.gwa = gwa;
    }

    public String toString() {
        return "Name: " + name + ", Course: " + course + ", GWA: " + (gwa < 0 ? "N/A" : gwa);
    }
}