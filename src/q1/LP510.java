package q1;

import java.util.Scanner;

public class LP510 {
    public static void main(String[] args) {
        try {
            var input = new Scanner(System.in);

            System.out.print("Enter a number: ");
            int num1 = input.nextInt();
            System.out.print("Enter a second number: ");
            int num2 = input.nextInt();

            while (num2 > 0) {
                int temp = num1 % num2;
                num1 = num2;
                num2 = temp;
            }

            System.out.println("The GCD is " + num1);

            input.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*
Enter a number: 32
Enter a second number: 40
The GCD is 8
*/