package q1.Week7;

import java.util.ArrayList;
import java.util.Scanner;

public class MSOE_2007_9 {
    //  3 6 1 1 2 3 4 5 1 3 6 2 9 4 2 3 4 6 6 7
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        
        //ALL initialization stuff, repeat if invalid
        int start = 0;
        int width = 0;
        String[] temp2;
        do {
        System.out.print("Bins start at: ");
        start = input.nextInt();

        System.out.print("Bin Width: ");
        width = input.nextInt();
        System.out.println();
        input.nextLine();
        System.out.print("Data set: ");
        temp2 = input.nextLine().split(" ");
        } while (!((biggest(temp2) - start + 1) % width == 0));

        //more initialization
        ArrayList<Integer> data = new ArrayList<>();
        //fills histogram
        int[] histogram = new int[biggest(data) - start + 1];
        for (int x = 0, y = start; x < histogram.length; x++, y++) {
            histogram[x] = y;
        }
        //didn't know i could declare multiple vars in a for loop, cool
        //fills bins
        int[][] bins = new int[(biggest(data) - start + 1) / width][width];

        for (int x = 0; x < temp2.length; x++) {
            data.add(Integer.parseInt(temp2[x]));
        }

        
        for (int x = 0; x < (biggest(data) - start + 1) / width; x++) {
            int countTemp = 0;
            for (int y = 0; y < width; y++) {
                bins[x][y] = histogram[countTemp + start];
                countTemp++;
            }
        }

        for (int[] n : bins) {
            int count = 0;
            for (int x = 0; x < n.length; x++) {
                for (int y = 0; y < data.size(); y++) {
                    if (n[x] == data.get(y)) {
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

    public static int biggest(ArrayList<Integer> list) {
        int biggest = 0;
        for (int x = 0; x < list.size(); x++) {
            if (list.get(x) > biggest) {
                biggest = list.get(x);
            }
        }
        return biggest;
    }

    public static int biggest(String[] list) {
        int biggest = 0;
        for (int x = 0; x < list.length; x++) {
            if (Integer.parseInt(list[x]) > biggest) {
                biggest = Integer.parseInt(list[x]);
            }
        }
        return biggest;
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