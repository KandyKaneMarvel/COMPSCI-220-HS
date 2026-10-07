package q1.Week2;

import java.util.Scanner;

public class prog82aClass {
    public class ticketer {
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
                this.fine = (tempCalc * this.BASERATE) + this.BASEFINE;
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
