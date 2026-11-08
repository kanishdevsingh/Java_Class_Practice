//package Nov3;
//
//
//import java.util.Scanner;
//
//class Patient {
//
//    int id;
//    String name;
//    int age;
//    String disease;
//    double bill;
//
//    Patient(int id, String name, int age, String disease) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.disease = disease;
//        this.bill = 0;
//    }
//}
//
//public class HospitalManagement {
//
//    static Scanner sc = new Scanner(System.in);
//    static Patient[] patients = new Patient[10];
//    static int count = 0;
//
//    public static void main(String[] args) {
//
//        int choice;
//
//        do {
//            System.out.println("\n--- HOSPITAL MANAGEMENT SYSTEM ---");
//            System.out.println("1. Add Patient");
//            System.out.println("2. View Patients");
//            System.out.println("3. Search Patient");
//            System.out.println("4. Generate Bill");
//            System.out.println("5. Exit");
//
//            System.out.print("Enter choice: ");
//            choice = sc.nextInt();
//            sc.nextLine();
//
//            switch (choice) {
//
//                case 1:
//                    addPatient();
//                    break;
//
//                case 2:
//                    viewPatients();
//                    break;
//
//                case 3:
//                    searchPatient();
//                    break;
//
//                case 4:
//                    generateBill();
//                    break;
//
//                case 5:
//                    System.out.println("Thank you!");
//                    break;
//
//                default:
//                    System.out.println("Invalid choice!");
//            }
//
//        } while (choice != 5);
//    }
//
//    static void addPatient() {
//
//        if (count == 10) {
//            System.out.println("Hospital record is full!");
//            return;
//        }
//
//        System.out.print("Enter Patient ID: ");
//        int id = sc.nextInt();
//        sc.nextLine();
//
//        System.out.print("Enter Patient Name: ");
//        String name = sc.nextLine();
//
//        System.out.print("Enter Patient Age: ");
//        int age = sc.nextInt();
//        sc.nextLine();
//
//        System.out.print("Enter Disease: ");
//        String disease = sc.nextLine();
//
//        patients[count] = new Patient(id, name, age, disease);
//        count++;
//
//        System.out.println("Patient added successfully!");
//    }
//
//    static void viewPatients() {
//
//        if (count == 0) {
//            System.out.println("No patients available!");
//            return;
//        }
//
//        for (int i = 0; i < count; i++) {
//
//            System.out.println("\nPatient ID: " + patients[i].id);
//            System.out.println("Name: " + patients[i].name);
//            System.out.println("Age: " + patients[i].age);
//            System.out.println("Disease: " + patients[i].disease);
//            System.out.println("Bill: Rs. " + patients[i].bill);
//        }
//    }
//
//    static void searchPatient() {
//
//        System.out.print("Enter Patient ID: ");
//        int id = sc.nextInt();
//
//        for (int i = 0; i < count; i++) {
//
//            if (patients[i].id == id) {
//
//                System.out.println("Patient Found!");
//                System.out.println("Name: " + patients[i].name);
//                System.out.println("Age: " + patients[i].age);
//                System.out.println("Disease: " + patients[i].disease);
//
//                return;
//            }
//        }
//
//        System.out.println("Patient not found!");
//    }
//
//    static void generateBill() {
//
//        System.out.print("Enter Patient ID: ");
//        int id = sc.nextInt();
//
//        for (int i = 0; i < count; i++) {
//
//            if (patients[i].id == id) {
//
//                System.out.print("Enter treatment charges: ");
//                double charges = sc.nextDouble();
//
//                System.out.print("Enter medicine charges: ");
//                double medicine = sc.nextDouble();
//
//                patients[i].bill = charges + medicine;
//
//                System.out.println("\n--- PATIENT BILL ---");
//                System.out.println("Patient Name: " + patients[i].name);
//                System.out.println("Treatment Charges: Rs. " + charges);
//                System.out.println("Medicine Charges: Rs. " + medicine);
//                System.out.println("Total Bill: Rs. " + patients[i].bill);
//
//                return;
//            }
//        }
//
//        System.out.println("Patient not found!");
//    }
//}
//
