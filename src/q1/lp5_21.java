package q1;

import java.util.Scanner;

public class lp5_21 {
    public static void main(String[] args) {
        try {
            var input = new Scanner(System.in);

            System.out.print("First Name: ");
            String firstName = input.nextLine();
            System.out.print("Last Name: ");
            String lastName = input.nextLine();

            String name = firstName + " " + lastName;
            String initial = lastName.substring(0, 1).toLowerCase();

            String[] group1 = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
            String[] group2 = {"j", "k", "l", "m", "n", "o", "p", "q", "r", "s"};
            String[] group3 = {"t", "u", "v", "w", "x", "y", "z"};

            //I'm cooking up straight slop with this one
            for (int x = 0; x < group2.length; x++) {
                if (!(x > group1.length)) {
                    if (initial.contains(group1[x])) {
                        System.out.printf("%s is assigned to Group 1.", name);
                        break;
                    }
                }
                if (initial.contains(group2[x])) {
                        System.out.printf("%s is assigned to Group 2.", name);
                        break;
                }
                if (!(x > group3.length)) {
                    if (initial.contains(group3[x])) {
                        System.out.printf("%s is assigned to Group 3.", name);
                        break;
                    }
                }
            }
            input.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
/*
First Name: Christina
Last Name: Briglio
Christina Briglio is assigned to Group 1.
*/