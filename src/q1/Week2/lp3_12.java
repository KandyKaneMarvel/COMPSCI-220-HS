package q1.Week2;

import java.util.Scanner;

public class lp3_12 {
    public static class ledger {
        double[] costs = new double[4];
        double[] percents = new double[4];

        public ledger(double expenses[]) {
            this.costs = expenses;
            calc();
        }

        public void calc() {
            double total = 0;
            for (double tempCost : costs) {
                total += tempCost;
            }
            // I'm gonna try to start using itr (iteration) from now on (unless I'm using a
            // table),
            // I think it's what Getka used
            for (int itr = 0; itr < costs.length; itr++) {
                this.percents[itr] = (this.costs[itr] / total) * 100;
            }
        }

        public double[] getPercents() {
            return this.percents;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the amount spent last month on the following items:\n");

        double[] expenses = { prompt("Food: "), prompt("Clothing: "), prompt("Entertainment: "), prompt("Rent: ") };
        ledger book = new ledger(expenses);
        var percents = book.getPercents();

        System.out.println("\nCategory\t\tBudget");
        System.out.printf("Food\t\t\t%.2f %%\n", percents[0]);
        System.out.printf("Clothing\t\t%.2f %%\n", percents[1]);
        System.out.printf("Entertainment\t\t%.2f %%\n", percents[2]);
        System.out.printf("Rent\t\t\t%.2f %%\n", percents[3]);
    }

    static Scanner inputPrompt = new Scanner(System.in);
    public static double prompt(String prompt) {
        System.out.print(prompt);
        double tempPrompt = inputPrompt.nextDouble();
        return tempPrompt;
    }
}
/*
Enter the amount spent last month on the following items:
Food: 350
Clothing: 300
Entertainment: 200
Rent: 1250

Category                Budget
Food                    16.67 %
Clothing                14.29 %
Entertainment           9.52 %
Rent                    59.52 %
*/
