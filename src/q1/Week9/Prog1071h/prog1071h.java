package q1.Week9.Prog1071h;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import DataStructures.QueueStack;

public class prog1071h {
    public static void main(String[] args) {
        //do inventory, read it out as you import the data
        //then, do everything in buysell
        try {
            var file = new Scanner(new File("Langdat\\bginvtry.txt"));
            var data = new QueueStack<unit>();
            while (file.hasNext()) {
                int c = file.nextInt();
                int q = file.nextInt();
                double p = file.nextDouble();

                data.enqueue(new unit(c, q, p));
            }
            file.close();

            var input = new Scanner(new File("Langdat\\buysell.txt"));

            

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
