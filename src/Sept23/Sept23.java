import java.util.Scanner;
class Employee{
    private String name;
    private double baseSalary;

    Employee(){
        name="unknown";
        baseSalary=0;
    }

    Employee(String name,double baseSalary){
this.name=name;
this.baseSalary=baseSalary;
}
public String getName(){
    return name;
}
public double getSalary(){
    return baseSalary;
}
public double calculateSalary(){
    return baseSalary;
}
}
class Manager extends Employee{
    private double bonus;
    Manager(String name,double baseSalary,double bonus){
        super(name,baseSalary);
        this.bonus=bonus;
    }

@Override
public double calculateSalary(){
    return baseSalary + bonus;
}
}
public class Sept23{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Manager name:");
        String name = sc.nextLine();
        System.out.println("Enter the basesalary:");
        double salary=sc.nextDouble();
        System.out.println("Enter the bonus amount:");
        double bonus=sc.nextDouble();
        Manager m=new Manager(name,baseSalary,bonus);
        double finalSalary=m.calculateSalary();
        System.out.println("Final Salary"+m.getName()+"="+finalSalary);
    }
}



