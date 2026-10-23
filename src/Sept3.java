

import java.util.Scanner;

class Vehicle{
    int vehicleNumber;
    String vehicleType;
    int hoursParked;

    Vehicle(String vehicleType, int vehicleNumber, int hoursParked){
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.hoursParked = hoursParked;
    }
}

class Parking{

    int toPay;
    int charge(Vehicle v1){
        if (v1.vehicleType.equalsIgnoreCase("bike")){
            toPay = v1.hoursParked * 20;
        }
        else if (v1.vehicleType.equalsIgnoreCase("car")){
            toPay = v1.hoursParked * 40;
        }
        else{
            toPay = v1.hoursParked * 60;
        }

        if (v1.hoursParked > 5){
            toPay = toPay + 50;
        }

        return toPay;
    }
}

public class Sept3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Your vehicle type: ");
        String type = sc.next();

        System.out.print("Vehicle Number: ");
        int vNo = sc.nextInt();

        System.out.print("Hours to park: ");
        int hours = sc.nextInt();

        Vehicle v1 = new Vehicle(type, vNo, hours);

        Parking p1 = new Parking();

        System.out.println("_______________________________________________________");
        System.out.println("You have to pay: \033[34m" + p1.charge(v1));

        sc.close();

    }
}