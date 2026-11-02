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
        } while (!((10 - start) % width == 0));

        input.nextLine();
        System.out.print("Data set: ");
        String[] temp2 = input.nextLine().split(" ");
        int[] data = new int[temp2.length];
        int[] histogram = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[][] bins = new int[(10 - start) / width][width];

        for (int x = 0; x < temp2.length; x++) {
            data[x] = Integer.parseInt(temp2[x]);
        }

        int countTemp = 0;
        for (int x = 0; x < (10 - start) / width; x++) {
            for (int y = 0; y < width; y++) {
                bins[x][y] = histogram[countTemp];
                countTemp++;
            }
        }

        for (int[] n : bins) {
            int count = 0;
            for (int x = 0; x < n.length; x++) {
                for (int y = 0; y < data.length; y++) {
                    if (n[x] == data[y]) {
                        count++;
                    }
                }
            }
            System.out.printf("%d - %d\t%s\n", n[0], n[n.length-1], "*".repeat(count));
        }
        
        input.close();

        //man I LOVE writing slop code
        //there was probably a much better way to do this
    }
}
/*
Bins start at: 0
Bin Width: 2

Data set: 3 6 1 1 2 3 4 5 1 3 6 2 9 4 2 3 4 6 6 7
0 - 1   ***
2 - 3   *******
4 - 5   ****
6 - 7   *****
8 - 9   *
*/