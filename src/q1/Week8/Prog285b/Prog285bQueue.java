package q1.Week8.Prog285b;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import DataStructures.Queue;

public class Prog285bQueue {
     public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog285b.dat"));
            var queue = new Queue<Cl285b>();

            System.out.println("ID\tCode\tSales\t\t\tCommission");
            while (file.hasNext()) {
                int id = file.nextInt();
                int code = file.nextInt();
                double sales = file.nextDouble();

                var sp = new Cl285b(id, code, sales);
                queue.enqueue(sp);
            }
            file.close();

            while (!queue.isEmpty()) {
                var temp = queue.dequeue();
                System.out.println(temp);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
ID      Code    Sales                   Commission
101     17      $2250.00                $213.75
103     5       $4000.00                $340.00
117     3       $7350.00                $0.00
118     8       $7350.00                $574.75
125     5       $6500.00                $502.50
138     17      $6375.00                $677.50
192     8       $8125.00                $640.63
203     8       $3250.00                $276.25
218     5       $5000.00                $425.00
235     5       $5250.00                $396.25
264     17      $4150.00                $410.50
291     17      $750.00         $71.25
 */