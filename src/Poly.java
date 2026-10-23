import java.util.*;
class Addition{
    int add(int x, int y, int z){
        return x + y + z;
    }

    double add(double x , double y , double z){
        return x + y + z;
    }
}


public class Poly {
    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        Addition a1 = new Addition();

        System.out.println("Enter 3 numbers:");
        int sum2 = a1.add(sc.nextInt(),sc.nextInt(),sc.nextInt());

        System.out.println("The sum of three numbers is:" + sum2);

        System.out.println("Enter three numbers:");
        double sum1= a1.add(sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
        System.out.println("Sum of three numbers is:"+sum1);

        sc.close();
    }
}
