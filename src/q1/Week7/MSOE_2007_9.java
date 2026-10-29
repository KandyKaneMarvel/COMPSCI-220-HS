package q1.Week7;

import java.util.Scanner;

public class MSOE_2007_9 {
    //  3 6 1 1 2 3 4 5 1 3 6 2 9 4 2 3 4 6 6 7
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        
        int start = 0;
        int width = 0;
        do {
        System.out.print("Bins start at: ");
        start = input.nextInt();

        System.out.print("Bin Width: ");
        width = input.nextInt();
        System.out.println();
        } while ((10 - start) % width == 0);

        input.nextLine();
        System.out.print("Data set: ");
        String[] temp = input.nextLine().split(" ");
        int[] data = new int[temp.length];
        int[] histogram = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[][] bins = new int[(10 - start) / width][width];

        for (int x = 0; x < temp.length; x++) {
            data[x] = Integer.parseInt(temp[x]);
        }

        for (int x = 0; x < width; x++) {
            
        }
    }
}
