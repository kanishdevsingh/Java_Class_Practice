//
//// // 21 - 08 - 2026
//
//import java.util.Scanner;
//
//class Check {
//    void odd_even(int x) {
//        if (x % 2 == 0) {
//            System.out.println("\033[32mThe given number is a Even number\033[0m");
//        } else if (x % 2 != 0) {
//            System.out.println("\033[32mThe given number is an Odd number\033[0m");
//        } else {
//            System.out.println("\033[32mThe given number is an Invalid Number \033[0m");
//        }
//    }
//
//    void prime(int x) {
//        int primeCount = 0;
//
//        if(x <= 1){
//            System.out.println("\033[31mThe given number is less than 1 -- 'NOT A PRIME NUMBER' \033[0m");
//            return ;
//        }
//
//        if (x >= 1) {
//            for (int i = 1; i <= x; i++) {
//                if (x % i == 0) {
//                    primeCount++;
//                }
//            }
//        }
//
//        if (primeCount == 2) {
//            System.out.println("\033[34mThe given number is a prime number\033[0m");
//        } else {
//            System.out.println("\033[31mThe given number is not a Prime number\033[0m");
//        }
//
//    }
//}
//
//
//public class Third {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int x = sc.nextInt();
//
//        Check check = new Check();
//        check.odd_even(x);
//        check.prime(x);
//    }
//}


