import java.util.Scanner;

class Employee{
    private String name;
    private int employeeCode;
    private double salary;

    public Employee(String name,int employeeCode,double salary)
    {
        this.name=name;
        this.employeeCode=employeeCode;
        this.salary=salary;
    }
    public String getName() {
        return name;
    }
    public int getEmployeeCode(){
        return employeeCode;
    }
    public double getSalary(){
        return salary;
    }
    public void displayDetails(){
        System.out.println("Employee Name:" + name);
        System.out.println("Employee Code:" + employeeCode);
        System.out.println("Employee Salary:" + salary);
    }
}
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Name:");
        String name = sc.nextLine();
        System.out.println("Enter Employee Code:");
        int code = sc.nextInt();
        System.out.println("Enter Salary:");
        double salary = sc.nextDouble();

        Employee emp = new Employee(name,code,salary);
        emp.displayDetails();
        sc.close();
    }
}