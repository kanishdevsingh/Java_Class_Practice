import java.util.*;

interface ResultCalculation {
    void getresult();
    void displayresult();
}
class Student1{
    private int rollNo;
    private String name;
    private int marks1;
    private int marks2;
    private int marks3;

    Student1(int rollNo,String name,int marks1,int marks2,int marks3){
        this.rollNo=rollNo;
        this.name=name;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    public int getRollNo(){
        return rollNo;
    }
    public String getname(){
        return name;
    }
    public int getMarks1() {
      return marks1;
    }
    public int getMarks2() {
        return marks2;
    }
    public int getMarks3() {
        return marks3;
    }
    public void displayResult() {
        System.out.println("Student Result");
    }
}
class Result extends Student1 implements ResultCalculation{

   private int total;
   private double percentage;
   private String grade;

    Result(int rollNo, String name, int marks1, int marks2, int marks3) {
       super(rollNo, name, marks1, marks2, marks3);
    }
    @Override
    public void calculateResult() {
        total = getMarks1() + getMarks2() + getMarks3();
        percentage = total / 3.0;

        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
    }
    @Override
    public void displayResult() {
       System.out.println("\n----- STUDENT RESULT -----");
        System.out.println("Roll Number : " + getRollNo());
        System.out.println("Name        : " + getname());
        System.out.println("Marks 1     : " + getMarks1());
        System.out.println("Marks 2     : " + getMarks2());
        System.out.println("Marks 3     : " + getMarks3());
        System.out.println("Total Marks : " + total);
        System.out.println("Percentage  : " + percentage + "%");
       System.out.println("Grade       : " + grade);
    }
}

public class Sys {
    public static void main(String[] args) {

      ResultCalculation student = new Result(101, "Aryan", 85, 90, 80);

        student.getresult();
      student.displayresult();
       }
}

