package q1;

import java.util.Scanner;

public class prog52a {
    public static void main(String[] args) {
        try {
            var input = new Scanner(System.in);

            System.out.print("Length: ");
            int length = input.nextInt();
            System.out.print("Width: ");
            int width = input.nextInt();

            System.out.println("\nArea: " + length * width);
            System.out.println("Perimeter: " + (length * 2 + width * 2));

            input.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}

/*
 * Length: 143
 * Width: 82
 * 
 * Area: 11726
 * Perimeter: 450
 */