package q1.Week2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class lp3_13 {
    public static class simpleInterest {
        double pOrA;
        int years;
        double interest;

        public simpleInterest(double p, int y, double i) {
            pOrA = p;
            years = y;
            interest = i;
        }

        public String computeSimpleInterest() {
            var moneyFormat = new DecimalFormat("$#,###.00");
            return moneyFormat.format(pOrA * (1 + years * interest));
        }

        public String computePrinciple() {
            var moneyFormat = new DecimalFormat("$#,###.00");
            return moneyFormat.format(pOrA / (1 + years * interest));
        }
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.print("Enter the principal: ");
        double principal = input.nextDouble();
        System.out.print("Enter the number of years: ");
        int years = input.nextInt();
        System.out.print("Enter the interest: ");
        double interest = input.nextDouble();

        simpleInterest pFinder = new simpleInterest(principal, years, interest);

        System.out.println("The value after the term is: "
                + pFinder.computeSimpleInterest());

        System.out.print("\nEnter the amount: ");
        double amount = input.nextDouble();
        System.out.print("Enter the number of years: ");
        years = input.nextInt();
        System.out.print("Enter the interest: ");
        interest = input.nextDouble();

        simpleInterest aFinder = new simpleInterest(amount, years, interest);

        System.out.println(
                "The required investment is: " + aFinder.computePrinciple());
        input.close();
    }

}
/*
 * Enter the principal: 5000
 * Enter the number of years: 5
 * Enter the interest: .06
 * The value after the term is: $6,500.00
 * 
 * Enter the amount: 5000
 * Enter the number of years: 5
 * Enter the interest: .06
 * The required investment is: $3,846.15
 */