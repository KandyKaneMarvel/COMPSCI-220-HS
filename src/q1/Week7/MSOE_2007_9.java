package q1.Week7;

import java.util.Scanner;
import java.util.stream.Gatherer.Integrator;

public class MSOE_2007_9 {
    //  3 6 1 1 2 3 4 5 1 3 6 2 9 4 2 3 4 6 6 7
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        
        System.out.print("Bins start at: ");
        int start = input.nextInt();

        System.out.print("Bin Width: ");
        int width = input.nextInt();

        input.nextLine();
        System.out.print("Data set: ");
        String[] temp = input.nextLine().split(" ");
        int[] data = new int[temp.length];

        for (int x = 0; x < temp.length; x++) {
            data[x] = Integer.parseInt(temp[x]);
        }

        
    }
}
