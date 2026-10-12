package q1.Week2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class prog464d {
    /**
     * Creates the transposed version of a 2D integer array.
     * @param mat A 2D array to be transposed.
     * @return  The transposed version of "mat".
     */
    public static int[][] transpose(int[][] mat) {
        int[][] transpose = new int[mat[0].length][mat.length];

        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                transpose[c][r] = mat[r][c];
            }
        }

        return transpose;
    }

    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog464a.dat"));
            int[][] mat = new int[5][5];

            for (int r = 0; r < mat.length; r++) {
                for (int c = 0; c < mat[0].length; c++) {
                    mat[r][c] = file.nextInt();
                }
            }
            file.close();

            System.out.println("Original: ");
            for (int[] row : mat) {
                for (int n : row) {
                    System.out.print(n + " ");
                }
                System.out.println();
            }

            int[][] transposed = transpose(mat);
            System.out.println("\nTransposed: ");
            for (int[] row : transposed) {
                for (int n : row) {
                    System.out.print(n + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}