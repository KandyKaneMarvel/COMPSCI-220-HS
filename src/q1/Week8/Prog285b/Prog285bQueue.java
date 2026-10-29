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

            System.out.println("ID\tCode\tSales\tCommission");
            while (file.hasNext()) {
                int id = file.nextInt();
                int code = file.nextInt();
                double sales = file.nextDouble();

                var sp = new Cl285b(id, code, sales);
                queue.enqueue(sp);
            }
            file.close();

            while (!queue.isEmpty()) {
                System.out.print(queue.dequeue());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
