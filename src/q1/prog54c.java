package q1;

import java.util.Scanner;

public class prog54c {
    public static void main(String[] args) {
        try {
            var input = new Scanner(System.in);
            final double pi = 3.14159;

            System.out.print("Radius: ");
            double r = input.nextDouble();
            double a = pi * Math.pow(r, 2);
            double c = 2 * pi * r;

            System.out.printf("Area: %.3f%n", a);
            System.out.printf("Circumference: %.3f%n", c);

            input.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
/*
Radius: 3.712
Area: 43.288
Circumference: 23.323
*/