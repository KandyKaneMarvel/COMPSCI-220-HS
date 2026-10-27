package q1.Week5;

import java.util.Iterator;
import java.util.LinkedList;

import DataStructures.IntLinkedList;

public class BigLinkedList {
    public static void main(String[] args) {
        var list = new IntLinkedList();
        for (int x  = 0; x < 200; x++) {
            list.addFront((int)(Math.random() * 100 + 1));
        }

        list.addFront(int n);
        list.print();

        list.addLast(int n);
        list.print();

        list.getCount();

        list.add(int n, int pos);
        list.print();

        list.isEmpty();

        list.getFirst();

        list.getLast();

        list.getByIndex(int pos);// (-1 if illegal position)

        list.removeFirst();

        list.removeLast();

        list.countLess10();

        list.removeIndex(int pos);

        list.contains(int n);

        list.getReverse();

        list.avg();

        list.min();

        list.max();

        list.indexOfMax();

        list.lastIndexOfMax();

        list.sort();

        list.lose58();

        list.getEvenCount();

        list.removeOdds();

        list.clear();

        var iterator = new Iterator<IntLinkedList>();
    }
}
