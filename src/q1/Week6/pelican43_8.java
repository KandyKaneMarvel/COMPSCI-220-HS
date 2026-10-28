package q1.Week6;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class pelican43_8 {
    public static class BankAccount { 
        public BankAccount(String nm, double amt) { 
            name = nm;
            balance = amt; 
        } 
 
        public void deposit(double dp) { 
            balance = balance + dp;
        } 
 
        public void withdraw(double wd) { 
            balance = balance - wd; 
        } 
        public String name; 
        public double balance; 
    } 

    public static void main(String[] args) {
        var list = new ArrayList<BankAccount>();

        String name = "";
        double deposit = 0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Please enter the name to whom the account belongs. (\"Exit\" to abort) ");
            if (!name.equals("")) {
                input.nextLine();
            }
            name = input.nextLine();
            if (name.toLowerCase().equals("exit")) {
                break;
            }
            System.out.print("Please enter the amount of the deposit. ");
            deposit = input.nextDouble();

            list.add(new BankAccount(name, deposit));
            System.out.println();
        } while (!name.toLowerCase().equals("exit"));

        var iter = list.iterator();

        BankAccount ba = iter.next();
        double maxBalance = ba.balance;
        String maxName = ba.name;
        while(iter.hasNext()) { 
            if (ba.balance > maxBalance) {
                maxBalance = ba.balance;
                maxName = ba.name;
            }
            ba = iter.next();
        } 
        System.out.println("The account with the largest balance belongs to " + maxName);
        NumberFormat formatter = new DecimalFormat("$#,###.##");
        System.out.println("The amount is " + formatter.format(maxBalance));

        input.close();
    }
}
/*
Please enter the name to whom the account belongs. ("Exit" to abort) Jotaro Kujoh
Please enter the amount of the deposit. 800

Please enter the name to whom the account belongs. ("Exit" to abort) Enrico Pucci
Please enter the amount of the deposit. 8000

Please enter the name to whom the account belongs. ("Exit" to abort) Bruno Bucciarati
Please enter the amount of the deposit. 4500

Please enter the name to whom the account belongs. ("Exit" to abort) exit
The account with the largest balance belongs to Enrico Pucci
The amount is $8,000
 */