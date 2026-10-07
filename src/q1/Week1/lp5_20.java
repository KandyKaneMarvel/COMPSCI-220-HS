package q1.Week1;

import java.util.Scanner;

public class lp5_20 {
    public static void main(String[] args) {
        try {
            var input = new Scanner(System.in);

            System.out.print("Enter text: ");
            String tempSentence = input.nextLine();
            String sentence = tempSentence.toLowerCase();

            int counter = 0;
            String[] letters = { "a", "e", "i", "o", "u", "y" };
            for (int x = 0; x < letters.length; x++) {
                while (sentence.contains(letters[x])) {
                    if (sentence.indexOf(letters[x]) < (sentence.length() - letters[x].length())) {
                        int temp = sentence.indexOf(letters[x]);
                        sentence = sentence.substring(0, temp) + sentence.substring(temp + letters[x].length());
                    } else {
                        int temp = sentence.indexOf(letters[x]);
                        sentence = sentence.substring(0, temp);
                    }
                    counter++;
                }
            }

            System.out.printf("The number of vowels in %s is %d.", tempSentence, counter);
            input.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
/*
Enter text: Java Programming Assignment            
The number of vowels in Java Programming Assignment is 8.
*/
