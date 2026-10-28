package q1.Week6;

import java.util.Scanner;

public class MSOE_2007_1 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        
        double height = 0;
        do {
            System.out.print("Input first height: ");
            height = input.nextDouble();
        } while (!(height > 0));

        double sh1 = 0;
        do {
            System.out.print("Input first shadow length: ");
            sh1 = input.nextDouble();
        } while (!(sh1 > 0));

        double sh2 = 0;
        do {
            System.out.print("Input second shadow length: ");
            sh2 = input.nextDouble();
        } while (!(sh2 > 0));

        System.out.printf("Second height: %.1f", height/sh1*sh2);

        input.close();
    }
}
/*
Input first height: 5
Input first shadow length: 2.5
Input second shadow length: 2.5
Second height: 5.0
*/