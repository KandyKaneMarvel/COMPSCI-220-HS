package q1;

import java.util.Scanner;

public class lp3_3 {
    public static void main(String[] args) {
        try {
            var input = new Scanner(System.in);

            String[] names = new String[6];
            double[] costs = new double[6];
            double[] offsets = new double[6];

            names[0] = "Housing and Food";
            names[1] = "Textbooks and Course Materials";
            names[2] = "Tuiton & Activity Fees";
            names[3] = "Personal Expenses";
            names[4] = "Transportation";
            names[5] = "Health and Wellness";

            for (int x = 0; x < names.length; x++) {
                System.out.print(names[x] + " expenses: ");
                costs[x] = input.nextDouble();
                System.out.print(names[x] + " offset cost: ");
                offsets[x] = input.nextDouble();
            }

            double total = 0;
            for (int x = 0; x < names.length; x++) {
                System.out.printf("+ %-10s Expenses: $%.2f%n", names[x], costs[x]);
                total += costs[x];
                System.out.printf("+ %-10s Offset: $%.2f%n", names[x], offsets[x]);
                total -= offsets[x];
            }
            System.out.println("-".repeat(20));
            System.out.printf("Total Cost: $%.2f", total);

            input.close();
            //I just made horrible code, wow, this is awful
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
