import java.util.*;
interface Student{
    void getDetails();
    void showDetails();
}
class StudentDetails implements Student{
    String name;
    int rollNo;
    int age;
    int marks;

    @Override
    public void getDetails(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        name = sc.nextLine();

        System.out.print("Enter student age: ");
        age = sc.nextInt();

        System.out.print("Enter roll number: ");
        rollNo = sc.nextInt();

        System.out.print("Enter marks: ");
        marks = sc.nextInt();
    }

    @Override
    public void showDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks: " + marks);
    }


}

public class intf {
    public static void main(String[] args) {
        Student s = new StudentDetails();

        s.getDetails();
        s.showDetails();
    }
}

//// Interface
//interface ResultOperations {
//    void calculateResult();
//    void displayResult();
//}
//
//// Parent class
//class Student {
//    // Encapsulated data members
//    private int rollNo;
//    private String name;
//    private int marks1;
//    private int marks2;
//    private int marks3;
//
//    // Constructor
//    Student(int rollNo, String name, int marks1, int marks2, int marks3) {
//        this.rollNo = rollNo;
//        this.name = name;
//        this.marks1 = marks1;
//        this.marks2 = marks2;
//        this.marks3 = marks3;
//    }
//
//    // Getters
//    public int getRollNo() {
//        return rollNo;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getMarks1() {
//        return marks1;
//    }
//
//    public int getMarks2() {
//        return marks2;
//    }
//
//    public int getMarks3() {
//        return marks3;
//    }
//
//    // Method to be overridden
//    public void displayResult() {
//        System.out.println("Student Result");
//    }
//}
//
//// Child class inheriting Student and implementing interface
//class Result extends Student implements ResultOperations {
//
//    private int total;
//    private double percentage;
//    private String grade;
//
//    // Constructor
//    Result(int rollNo, String name, int marks1, int marks2, int marks3) {
//        super(rollNo, name, marks1, marks2, marks3);
//    }
//
//    // Method implementation from interface
//    @Override
//    public void calculateResult() {
//        total = getMarks1() + getMarks2() + getMarks3();
//        percentage = total / 3.0;
//
//        if (percentage >= 90) {
//            grade = "A+";
//        } else if (percentage >= 80) {
//            grade = "A";
//        } else if (percentage >= 70) {
//            grade = "B";
//        } else if (percentage >= 60) {
//            grade = "C";
//        } else if (percentage >= 50) {
//            grade = "D";
//        } else {
//            grade = "F";
//        }
//    }
//
//    // Method overriding
//    @Override
//    public void displayResult() {
//        System.out.println("\n----- STUDENT RESULT -----");
//        System.out.println("Roll Number : " + getRollNo());
//        System.out.println("Name        : " + getName());
//        System.out.println("Marks 1     : " + getMarks1());
//        System.out.println("Marks 2     : " + getMarks2());
//        System.out.println("Marks 3     : " + getMarks3());
//        System.out.println("Total Marks : " + total);
//        System.out.println("Percentage  : " + percentage + "%");
//        System.out.println("Grade       : " + grade);
//    }
//}
//
//// Main class
//public class StudentResultSystem {
//    public static void main(String[] args) {
//
//        // Polymorphism
//        ResultOperations student = new Result(101, "Aryan", 85, 90, 80);
//
//        // Calling methods through interface reference
//        student.calculateResult();
//        student.displayResult();
//    }
}