package Nov3;

import java.io.*;
import java.util.*;

class Student{
    String name;
    int rollno;
    int n1,n2,n3;
    int total;
   double percent;

    Student(String name,int rollno,int n1,int n2,int n3){
        this.name=name;
        this.rollno=rollno;
        this.n1=n1;
        this.n2=n2;
        this.n3=n3;
    }
    void result(){
        total=n1+n2+n3;
    }
    void display(){
        System.out.println("Name: "+name);
        System.out.println("Rollno:"+rollno);
        System.out.println("Marks1:"+n1);
        System.out.println("Marks2:"+n2);
        System.out.println("Marks3:"+n3);

        if(n1 >= 33 && n2 >= 33 && n3 >= 33){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
        }
    }
    void saveFile(){
        try{
            FileWriter fw = new FileWriter("result text");
            fw.write("Name: "+name);
            fw.write("Rollno:"+rollno);
            fw.write("Marks1:"+n1);
            fw.write("Marks2:"+n2);
            fw.write("Marks3:"+n3);

            if(n1 >= 33 && n2 >= 33 && n3 >= 33){
                fw.write("PASS");
            }
            else{
                fw.write("FAIL");
            }
            System.out.println("File is saved");
        }
        catch(Exception e){
            System.out.println("An error occured"+e.getMessage());
        }
    }
}
public class Nov5 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name:");
        String name = sc.nextLine();

        System.out.println("Enter your rollno:");
        int rollno = sc.nextInt();

        System.out.println("Enter Marks1:");
        int n1=sc.nextInt();

        System.out.println("Enter Marks2:");
        int n2=sc.nextInt();

        System.out.println("Enter Marks3:");
        int n3=sc.nextInt();
        Student s = new Student(name,rollno,n1,n2,n3);
        s.result();
        s.display();
        s.saveFile();

    }
}
