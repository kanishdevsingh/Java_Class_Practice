package Nov3;


import java.util.Scanner;

class Customer {

    int id;
    String name;
    int units;
    double bill;

    Customer(int id, String name, int units) {
        this.id = id;
        this.name = name;
        this.units = units;
        this.bill = 0;
    }

    void calculateBill() {

        if (units <= 100) {
            bill = units * 2.50;
        }
        else if (units <= 200) {
            bill = (100 * 2.50) + (units - 100) * 4.00;
        }
        else {
            bill = (100 * 2.50)
                    + (100 * 4.00)
                    + (units - 200) * 6.00;
        }
    }

    void displayBill() {

        System.out.println("\n--- ELECTRICITY BILL ---");
        System.out.println("Customer ID: " + id);
        System.out.println("Customer Name: " + name);
        System.out.println("Units Consumed: " + units);
        System.out.println("Total Bill: Rs. " + bill);
    }
}

public class ElectricityBill {

    static Scanner sc = new Scanner(System.in);
    static Customer[] customers = new Customer[10];
    static int count = 0;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n--- ELECTRICITY BILL SYSTEM ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Calculate Bill");
            System.out.println("3. View All Bills");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addCustomer();
                    break;

                case 2:
                    calculateBill();
                    break;

                case 3:
                    viewBills();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }

    static void addCustomer() {

        if (count == 10) {
            System.out.println("Customer limit reached!");
            return;
        }

        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Units Consumed: ");
        int units = sc.nextInt();

        if (units < 0) {
            System.out.println("Units cannot be negative!");
            return;
        }

        customers[count] = new Customer(id, name, units);
        count++;

        System.out.println("Customer added successfully!");
    }

    static void calculateBill() {

        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (customers[i].id == id) {

                customers[i].calculateBill();
                customers[i].displayBill();

                return;
            }
        }

        System.out.println("Customer not found!");
    }

    static void viewBills() {

        if (count == 0) {
            System.out.println("No customers available!");
            return;
        }

        for (int i = 0; i < count; i++) {

            customers[i].calculateBill();
            customers[i].displayBill();
        }
    }
}
