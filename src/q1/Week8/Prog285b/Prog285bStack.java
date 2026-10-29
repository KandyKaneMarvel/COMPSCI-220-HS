package q1.Week8.Prog285b;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Prog285bStack {
     public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog285b.dat"));
            var stack = new Stack<Cl285b>();

            System.out.println("ID\tCode\tSales\tCommission");
            while (file.hasNext()) {
                int id = file.nextInt();
                int code = file.nextInt();
                double sales = file.nextDouble();

                var sp = new Cl285b(id, code, sales);
                stack.push(sp);
            }
            file.close();

            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
