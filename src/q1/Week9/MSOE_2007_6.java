package q1.Week9;

import java.lang.Math;
import java.util.Scanner;

public class MSOE_2007_6 {
    public static double f(double x) {
        return Math.exp(-x*x/2)/Math.sqrt(2*Math.PI);
    }

    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.print("a: ");
        double a = input.nextInt();
        System.out.print("b: ");
        double b = input.nextInt();
        System.out.print("n: ");
        int n = input.nextInt();
        System.out.println();

        double h = (b-a)/(n);
        var area = f(a);

        for (int x = 0; x < n; x++) {
            area += 2*f(a + (n-x)*h);
        }

        area *= (h/2);

        System.out.printf("Area = %.4f", area);

        input.close();
    }
}
/*
a: -1
b: 2
n: 100

Area = 0.8194

a: -1
b: 2
n: 1000

Area = 0.8187

a: -1
b: 2
n: 10000

Area = 0.8186
*/