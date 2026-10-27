package q1.Week5;

import java.util.Iterator;

import DataStructures.IntLinkedList;

public class BigLinkedList {
    public static void main(String[] args) {
        var list = new IntLinkedList();
        for (int x  = 0; x < 200; x++) {
            list.addFront((int)(Math.random() * 100 + 1));
        }

//jhfiuowhi

        //why use an iterator? we already have a function for it.
        list.print(); 
    }
}
