package q1.Week7;

import DataStructures.DoublyLinkedList;

public class testDLlistRandom {
    public static void main(String[] args) {
        var list = new DoublyLinkedList<Integer>();

        for (int x = 0; x < 20; x++) {
            list.addSorted((int)(Math.random() * 100));
        }

        list.print();
        list.printReverse();

        int n = (int)(Math.random() * 100);
        list.add(n);
        System.out.println("Added " + n + " to back of list.");
        n = (int)(Math.random() * 100);
        list.addFront(n);
        System.out.println("Added " + n + " to front of list.");

        int pos = (int)(Math.random() * list.size() - 1);
        n = (int)(Math.random() * 100);
        list.insert(pos, n);
        System.out.println("Added " + n + " to index " + pos + ".");
        pos = (int)(Math.random() * list.size() - 1);
        System.out.println("Removed " + list.get(pos) + " from index " + pos + ".");
        list.remove(pos);

        n = (int)(Math.random() * 100);
        pos = (int)(Math.random() * list.size() - 1);
        list.set(pos, n);
        System.out.println("Set index " + pos + " to " + n + ".");

        n = (int)(Math.random() * 100);
        list.removeItem(n);
        System.out.println("Removed " + n + " from list.");

        System.out.println("Removed tail: " + list.pop() + "\n");

        var iter = list.iterator();
        System.out.print("[");
        while (iter.hasNext()) {
            System.out.print(iter.next() + ", ");
        }
        System.out.print("]");
    }
}
/*
[2, 5, 8, 10, 11, 24, 28, 30, 39, 41, 48, 54, 56, 60, 65, 67, 69, 76, 96, 99, ]
[99, 96, 76, 69, 67, 65, 60, 56, 54, 48, 41, 39, 30, 28, 24, 11, 10, 8, 5, 2, ]
Added 88 to back of list.
Added 76 to front of list.
Added 75 to index 0.
Removed 10 from index 5.
Set index 0 to 95.
Removed 72 from list.
Removed tail: 88

[95, 76, 2, 5, 8, 11, 24, 28, 30, 39, 41, 48, 54, 56, 60, 65, 67, 69, 76, 96, 99, 88, ]
 */