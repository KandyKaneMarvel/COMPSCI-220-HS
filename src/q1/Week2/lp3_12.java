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
            //I'm gonna try to start using itr (iteration) from now on (unless I'm using a table),
            //I think it's what Getka used
            for (int itr = 0; itr < costs.length; itr++) {
                this.percents[itr] = (this.costs[itr] / total) * 100;
            }
        }

        public double[] getPercents() {
            return this.percents;
         }
    }

    public static double prompt(String prompt) {
            var inputPrompt = new Scanner(System.in);
            System.out.print(prompt);
            double tempPrompt = inputPrompt.nextDouble();
            inputPrompt.close();
            return tempPrompt;
    }
    public static void main(String[] args) {
        System.out.println("Enter the amount spent last month on the following items:\n");
        
        double[] expenses = {prompt("Food: "), prompt("Clothing: "), prompt("Entertainment: "), prompt("Rent: ")};
        ledger book = new ledger(expenses);
        var percents = book.getPercents();
        
        
    }
}
