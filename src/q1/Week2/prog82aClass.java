package q1.Week2;

import java.util.Scanner;

public class prog82aClass {
    public static class ticketer {
        int spd;
        int spdLimit;
        double fine;
        final static double BASEFINE = 20.00;
        final static double BASERATE = 5.00;

        public ticketer() {
            this.spdLimit = prompt("Enter the speed limit: ");
            this.spd = prompt("Enter the vehicle speed: ");
        }

        public int prompt(String prompt) {
            Scanner inputPrompt = new Scanner(System.in);
            System.out.print(prompt);
            int tempPrompt = inputPrompt.nextInt();
            inputPrompt.close();
            return tempPrompt;
        }

        public void calc() {
            int tempCalc = this.spd - this.spdLimit;
            if (tempCalc <= 0) {
                this.fine = 0;
            } else {
                this.fine = (tempCalc * BASERATE) + BASEFINE;
            }
        }

        public String getFine() {
            if (this.fine == 0) {
                calc();
            }
            return "$" + this.fine;
        }
    }
    public static void main(String[] args) {
        ticketer cop = new ticketer();

        cop.calc();

        System.out.printf("Fine" + "-".repeat(10) + "$%.2%f", cop.getFine());
    }
}
//COME BACK AND ADD OUTPUT, OLDER JAVA DOESN'T HAVE REPEAT OR VAR