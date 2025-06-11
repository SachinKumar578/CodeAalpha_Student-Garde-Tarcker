import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("---- Student Grade Tracker ----");
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // consume leftover newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter " + name + "'s score: ");
            int score = scanner.nextInt();
            scanner.nextLine();  // consume leftover newline

            students.add(new Student(name, score));
        }

        if (students.isEmpty()) {
            System.out.println("No student data entered.");
            return;
        }

        int total = 0;
        int highest = students.get(0).score;
        int lowest = students.get(0).score;

        for (Student s : students) {
            total += s.score;
            if (s.score > highest) highest = s.score;
            if (s.score < lowest) lowest = s.score;
        }

        double average = (double) total / students.size();

        // Summary Report
        System.out.println("\n---- Summary Report ----");
        for (Student s : students) {
            System.out.println("Name: " + s.name + ", Score: " + s.score);
        }

        System.out.printf("Average Score: %.2f\n", average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
    }
}
