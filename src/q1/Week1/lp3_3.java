package q1.Week1;

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
            System.out.println();

            double total = 0;
            for (int x = 0; x < names.length; x++) {
                System.out.printf("+ %-10s Expenses: $%.2f%n", names[x], costs[x]);
                total += costs[x];
                System.out.printf("- %-10s Offset: $%.2f%n", names[x], offsets[x]);
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
/*
Housing and Food expenses: 2500
Housing and Food offset cost: 500
Textbooks and Course Materials expenses: 10000
Textbooks and Course Materials offset cost: 5000
Tuiton & Activity Fees expenses: 1500
Tuiton & Activity Fees offset cost: 1000
Personal Expenses expenses: 200
Personal Expenses offset cost: 0
Transportation expenses: 5000
Transportation offset cost: 3000
Health and Wellness expenses: 0
Health and Wellness offset cost: 0

+ Housing and Food Expenses: $2500.00
- Housing and Food Offset: $500.00
+ Textbooks and Course Materials Expenses: $10000.00
- Textbooks and Course Materials Offset: $5000.00
+ Tuiton & Activity Fees Expenses: $1500.00
- Tuiton & Activity Fees Offset: $1000.00
+ Personal Expenses Expenses: $200.00
- Personal Expenses Offset: $0.00
+ Transportation Expenses: $5000.00
- Transportation Offset: $3000.00
+ Health and Wellness Expenses: $0.00
- Health and Wellness Offset: $0.00
--------------------
Total Cost: $9700.00
*/
