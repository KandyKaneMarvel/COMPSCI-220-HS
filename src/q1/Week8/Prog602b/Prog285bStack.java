package q1.Week8.Prog602b;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Prog285bStack {
     public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog602b.dat"));
            var stack = new Stack<Cl602b>();

            System.out.println("Number\tHours\tCode\t\tDue");
            while (file.hasNext()) {
                int number = file.nextInt();
                double hours = file.nextDouble();
                int code = file.nextInt();

                var sp = new Cl602b(number, hours, code);
                stack.push(sp);
            }
            file.close();

            while (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Number  Hours   Code            Due
29118   $15.02  0               $550.60
23051   $1.55   2               $350.00
22841   $27.90  2               $1087.00
21352   $5.84   0               $242.00
20045   $5.00   1               $250.00
19111   $12.00  2               $700.00
17185   $7.93   1               $396.50
14063   $17.06  1               $661.80
1825    $3.25   0               $200.00
 */