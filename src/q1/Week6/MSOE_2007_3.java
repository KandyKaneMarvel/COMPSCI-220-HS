package q1.Week6;

import java.util.Scanner;

public class MSOE_2007_3 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.print("Enter Angle A: ");
        double a = input.nextDouble();
        System.out.print("Enter Angle B: ");
        double b = input.nextDouble();
        System.out.print("Enter Angle C: ");
        double c = input.nextDouble();
        System.out.print("Enter length of side opposite Angle C: ");
        double cSide = input.nextDouble();

        if (a + b + c < 181 && a + b + c > 179) {
            System.out.println("ERROR! Angles are incorrect!");
        } else {
            a = Math.toRadians(a);
            b = Math.toRadians(b);
            c = Math.toRadians(c);
            double r = cSide * Math.sin(a/2) * Math.sin(b/2) * (1/Math.cos(c/2));

            System.out.println("Radius: " + r);
        }
        input.close();
    }
}
