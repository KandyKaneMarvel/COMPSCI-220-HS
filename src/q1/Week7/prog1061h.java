package q1.Week7;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import DataStructures.DoublyLinkedList;

public class prog1061h {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/prog1061h.dat"));
            var list = new DoublyLinkedList<String>();

            while (file.hasNextLine()) {
                String command = file.nextLine();
                if (command.substring(0, 1).equals("A")) {
                    list.addSorted(command.substring(1));
                } else if (command.substring(0, 1).equals("D")) {
                    list.removeItem(command.substring(1));
                } else if (command.substring(0, 1).equals("P")) {
                    list.print();
                }
            }
            file.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
