package q1.Week6;

import DataStructures.LinkedList;

public class testLinkedList {
    public static void main(String[] args) {
        var list = new LinkedList<Integer>();

        for (int x : new int[]{1, 2, 3, 4, 5}) {
            list.add(x);
        }
        list.print();
        list.remove(2);
        list.print();
        list.remove(0);
        list.print();
        list.remove(1);
        list.print();


    }
}
/*
[1, 2, 3, 4, 5, ]
[1, 2, 4, 5, ]
[2, 4, 5, ]
[2, 5, ]
*/