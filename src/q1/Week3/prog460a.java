package q1.Week3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import Algorithms.SearchAlgorithms;

public class prog460a {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/sort.dat"));
            var list = new ArrayList<Integer>();

            while (file.hasNext()) {
                list.add(file.nextInt());
            }
            file.close();

            int lcv = 0;
            var arr = new Integer[list.size()];
            for (var n : list) {
                arr[lcv++] = n;
            }

            var num = 0;
            var input = new Scanner(System.in);
            do {
                System.out.print("Enter a number to search for: ");
                num = input.nextInt();
                int pos = SearchAlgorithms.binarySearchRecursive(arr, num);
                System.out.println(pos == -1 ? "Your number does not appear in the list.\n"
                                            : "Your number occurs at index " + pos + "\n");
                
            } while (num != 0);
            input.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
Enter a number to search for: 6
Your number does not appear in the list.

Enter a number to search for: 2
Your number occurs at index 2

Enter a number to search for: 1
Your number occurs at index 0

Enter a number to search for: 4
Your number occurs at index 4
*/
