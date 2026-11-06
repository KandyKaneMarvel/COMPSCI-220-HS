package q1.Week8;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class prog1060b {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String command = "";
        Queue<Integer> list = new LinkedList<Integer>();

        do {
            System.out.print("Enter task A)dd D)elete E)xit ");
            command = input.next();

            if (command.equalsIgnoreCase("e")) {
                break;
            }

            System.out.print("enter number ");
            int a = input.nextInt();

            if (command.equalsIgnoreCase("a")) {
                push(list, a);
            } else if (command.equalsIgnoreCase("d")) {
                pop(list, a);
            }

            traverse(list);
        } while (!(command.equalsIgnoreCase("e")));

        input.close();
    }

    public static void push(Queue<Integer> list, int n) {
        list.add(n);
    }

    public static void pop(Queue<Integer> list, int n) {
        if (!list.remove(n)) {
            System.out.println("Number does not exit");
        }
    }

    public static void traverse(Queue<Integer> list) {
        System.out.println("This is the list\n" + list.toString());
    }
}
/*
Enter task A)dd D)elete E)xit A
enter number 10
This is the list
[10]
Enter task A)dd D)elete E)xit A
enter number 15
This is the list
[10, 15]
Enter task A)dd D)elete E)xit A
enter number 2
This is the list
[10, 15, 2]
Enter task A)dd D)elete E)xit D
enter number 10
This is the list
[15, 2]
Enter task A)dd D)elete E)xit D
enter number 2
This is the list
[15]
Enter task A)dd D)elete E)xit D 
enter number 15
This is the list
[]
Enter task A)dd D)elete E)xit A
enter number 7
This is the list
[7]
Enter task A)dd D)elete E)xit D
enter number 8
Number does not exit
This is the list
[7]
Enter task A)dd D)elete E)xit A
enter number 12
This is the list
[7, 12]
Enter task A)dd D)elete E)xit E
 */