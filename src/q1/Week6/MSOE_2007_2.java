package q1.Week6;

import java.util.Scanner;

public class MSOE_2007_2 {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.print("Enter String: ");
        String sentence = input.next();

        char[] list = sentence.toCharArray();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int count = 0;
        for (char n : list) {
            for (char v : vowels) {
                if (n == v) {
                    count++;
                }
            }
        }

        System.out.println("Your string contains " + count + " vowels!");
        input.close();
    }
}
