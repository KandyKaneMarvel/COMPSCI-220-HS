package q1;

import java.util.Scanner;

public class lp5_19 {
    public static void main(String[] args) {
        try {
            var input = new Scanner(System.in);
            
            System.out.print("Enter a sentence: ");
            String sentence = input.nextLine();
            System.out.print("Enter a string: ");
            String remove = input.nextLine();

            //did not know about .contains, thanks quick fix
            while (sentence.contains(remove)) {
                if (sentence.indexOf(remove) < (sentence.length() - remove.length())) {
                    int temp = sentence.indexOf(remove);
                    sentence = sentence.substring(0, temp) + sentence.substring(temp + remove.length());
                } else {
                    int temp = sentence.indexOf(remove);
                    sentence = sentence.substring(0, temp);
                }
            }

            System.out.println(sentence);
            input.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
/*
Enter a sentence: I really hope you get an interview.
Enter a string: really
I  hope you get an interview.
*/
