package q1.Week2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class lp3_13 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        var moneyFormat = new DecimalFormat("$#,###.00");

        System.out.print("Enter the principal: ");
        double principal = input.nextDouble();
        System.out.print("Enter the number of years: ");
        int years = input.nextInt();
        System.out.print("Enter the interest: ");
        double interest = input.nextDouble();
        
    }

    public static double computeSimpleInterest(double principal, int years, double interest) {
        
    }
}
