//package Oct23;
//import java.sql.SQLOutput;
//import java.util.Scanner;
//class Billing extends Thread{
//    public void run(){
//        for(int i = 0; i < 10; i++){
//            System.out.println("Generate billing: "+i);
//        }
//    }
//}
//
//class Packing extends Thread{
//    public void run(){
//        for(int i = 0; i < 10; i++){
//            System.out.println("Packing items: "+i);
//        }
//    }
//}
//
//class Delivery extends Thread{
//    public void run(){
//        for(int i = 0; i < 10; i++){
//            System.out.println("Delivery items: "+i);
//        }
//    }
//}
//public class Oct30{
//    public static void main(String[] args) {
//        Billing thread1 = new Billing();
//        Packing thread2 = new Packing();
//        Delivery thread3 = new Delivery();
//
//        thread1.start();
//
//        thread2.start();
//
//        thread3.start();
//    }
//}
