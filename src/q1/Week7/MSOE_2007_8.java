package q1.Week7;

import java.util.Scanner;

// 4x5
// 3 6 1 1 2 3 4 5 1 3 6 2 9 4 2 3 4 6 6 7
public class MSOE_2007_8 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        
        System.out.print("Number of rows: ");
        var rows = input.nextInt();

        System.out.print("Number of columns: ");
        var columns = input.nextInt();

        input.nextLine();
        System.out.print("Altitude Data: ");
        String tempData = input.nextLine();
        String[] tempData2 = tempData.split(" ");
        int[][] data = new int[columns][rows];
        int count = 0;
        for (int x = 0; x < data.length; x++) {
            for (int y = 0; y < data[0].length; y++) {
                data[x][y] = Integer.parseInt(tempData2[count]);
                count++;
            }
        }

        for (int x = 1; x < data.length - 1; x++) {
            for (int y = 1; y < data[0].length - 1; y++) {
                boolean highPoint = true;
                for (int a = -1; a < 2; a++) {
                    for (int b = -1; b < 2; b++) {
                        if (data[x][y] <= data[x+a][y+b]) {
                            if (a == 0 && b == 0) {
                                continue;
                            } else {
                                highPoint = false;
                            }
                        }
                    }
                }
                if (highPoint == true) {
                    System.out.println("Highpoint " + data[x][y] + " found at " + (x + 1) + ", " + (y + 1));
                }
            }
        }
    }
}
/*
Number of rows: 4
Number of columns: 5
Altitude Data: 3 6 1 1 2 3 4 5 1 3 6 2 9 4 2 3 4 6 6 7
Highpoint 6 found at 3, 3
 */