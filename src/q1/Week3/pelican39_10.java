package q1.Week3;

import java.util.Scanner;
import java.io.IOException;

public class pelican39_10 {
 public static void main(String args[]) { 
    var kbReader = new Scanner(System.in); 
    System.out.print("Generate which term number? ");
    int k = kbReader.nextInt( ); 
 
    System.out.println("Term #" + k + " is " + ModFib.modFibonacci(k)); 

    kbReader.close();
 } 

 public static class ModFib {
    public static int modFibonacci(int k) {
        if (k == -1) {
            return 0;
        }
        if (k == 0) {
            return 3;
        }
        if (k == 1) {
            return 5;
        }
        return modFibonacci(k-1) + modFibonacci(k-2) + modFibonacci(k-3);
    }
 }
}
/*
Generate which term number? 5
Term #5 is 53

Generate which term number? 6
Term #6 is 98
*/