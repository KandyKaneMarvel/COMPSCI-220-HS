package q1.Week2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class prog82aClass {
    public static class ticketer {
        int spd;
        int spdLimit;
        double fine;
        final static double BASEFINE = 20.00;
        final static double BASERATE = 5.00;

        public ticketer(int limit, int speed) {
            this.spdLimit = limit; //prompt("Enter the speed limit: ");
            this.spd = speed; //prompt("Enter the vehicle speed: ");
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
             var moneyFormat = new DecimalFormat("$###.00");
            return moneyFormat.format(this.fine);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the speed limit: ");
        int limit = input.nextInt();
        System.out.print("Enter the vehicle speed: ");
        int speed = input.nextInt();

        ticketer cop = new ticketer(limit, speed);

        cop.calc();

        System.out.println("Fine" + "-".repeat(15) + cop.getFine());
        input.close();
    }
}
/*
Enter the speed limit: 30
Enter the vehicle speed: 42
Fine---------------$80.00

Enter the speed limit: 55
Enter the vehicle speed: 70
Fine---------------$95.00
 */