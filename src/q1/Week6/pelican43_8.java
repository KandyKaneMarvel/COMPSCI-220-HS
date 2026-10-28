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
        var iter = list.iterator();

        String name = "";
        double deposit = 0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Please enter the name to whom the account belongs. (\"Exit\" to abort) ");
            name = input.next();
            System.out.print("Please enter the amount of the deposit. ");
            deposit = input.nextDouble();

            list.add(new BankAccount(name, deposit));
            System.out.println();
        } while (!name.toLowerCase().equals("exit"));

        BankAccount ba = iter.next();
        double maxBalance = ba.balance; //set last account as winner so far
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
