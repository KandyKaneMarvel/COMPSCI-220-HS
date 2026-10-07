package q1.Week1;

import java.util.Scanner;

public class lp3_5 {
    public static void main(String[] args) {
        try {
            var input = new Scanner(System.in);
            int days = 0;

            System.out.println("Enter your birthdate:");
            System.out.print("Enter your birth year: ");
            days -= input.nextInt() * 365;
            System.out.print("Enter your birth month: ");
            days -= input.nextInt() * 30;
            System.out.print("Enter your birth day: ");
            days -= input.nextInt();

            System.out.println("\nEnter the current date:");
            System.out.print("Enter the year: ");
            days += input.nextInt() * 365;
            System.out.print("Enter the month: ");
            days += input.nextInt() * 30;
            System.out.print("Enter the day: ");
            days += input.nextInt();

            System.out.printf("You have been alive for %,d days.\n", days);
            System.out.printf("You have slept for %,d hours.", days * 8);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
/*
Enter your birthdate:
Enter your birth year: 1997
Enter your birth month: 2
Enter your birth day: 12

Enter the current date:
Enter the year: 2012
Enter the month: 8
Enter the day: 3
You have been alive for 5,646 days.
You have slept for 45,168 hours.
 */
