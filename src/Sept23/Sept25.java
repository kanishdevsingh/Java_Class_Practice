package Sept23;

import java.sql.SQLOutput;
import java.util.Scanner;
interface Vehicle {
    void rentVehicle();

    double calculateRent();
}
class Car implements Vehicle {
    String vehicleNumber;
    String model;
    int rentalDays;

    Car(String vehicleNumber, String model, int rentalDays){
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.rentalDays = rentalDays;
    }
public void rentVehicle(){
    System.out.println("Car Rented:"+ model + "(" + vehicleNumber + ")");
}
public double calculateRent(){
    return rentalDays * 1000;
    }
}
class Bike implements Vehicle{
    String vehicleNumber;
    String model;
    int rentalDays;
    Bike(String vehicleNumber, String model, int rentalDays){
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.rentalDays = rentalDays;
    }
public void rentVehicle(){
    System.out.println("Bike Rented:"+ model + "(" + vehicleNumber + ")");
    }
public double calculateRent(){
    return rentalDays * 500;
    }
}
public class Sept25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter car no:");
        String carNo = sc.nextLine();
        System.out.println("Enter model:");
        String carModel = sc.nextLine();
        System.out.println("Enter rental days:");
        int carDays = sc.nextInt();
        sc.nextLine();

        Vehicle car = new Car(carNo, carModel, carDays);

        System.out.println("Enter Bike no:");
        String bikeNo = sc.nextLine();
        System.out.println("Enter Bike model:");
        String bikeModel = sc.nextLine();
        System.out.println("Enter Bike rental days:");
        int bikeDays = sc.nextInt();
        Vehicle bike = new Bike(bikeNo, bikeModel, bikeDays);
        System.out.println("\n--- Rental Details ---");
        car.rentVehicle();
        System.out.println("Car Rent Amount:"+car.calculateRent());
        bike.rentVehicle();
        System.out.println("Bike Rent Amount:"+bike.calculateRent());
        sc.close();
    }
}



