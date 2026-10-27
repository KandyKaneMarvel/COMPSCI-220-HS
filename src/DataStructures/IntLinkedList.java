package DataStructures;

import java.util.Iterator;

/*
public boolean contains(int n)
public IntLinkedList getReverse()
public Iterator<Integer> iterator()
public double avg()
public int min()
public int max()
public int indexOfMax()
public int lastIndexOfMax()
public void sort()
public int lose58()
public int getEvenCount()
public void removeOdds()
public void clear()
*/

public class IntLinkedList implements Iterable<Integer> {
    private class Node {
        int data;
        //i prefer "mynext" more so i'll be using that instead of "next"
        Node mynext;

        private Node(int data) {
            this.data = data;
            this.mynext = null;
        }
    }

    private Node head;

    public IntLinkedList() {
        head = null;
    }

    public void addFront(int data) {
        var node = new Node(data);
        node.mynext = head;
        head = node;
    }

    public boolean add(int n, int pos) {
        if (pos == 0) {
            addFront(n);
            return true;
        }
        var current = head;
        var node = new Node(n);
        for (int x = 0; x < pos - 1; x++) {  
            if (current == null) {
                return false;
            }
            current = current.mynext;
        }
        node.mynext = current.mynext; 
        current.mynext = node;
        return true;
    }

    public void addLast(int data) {
        var node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        var current = head;
        while (current.mynext != null) {
            current = current.mynext;
        }
        current.mynext = node;
    }

    public void removeFirst() {
        head = head.mynext;
    }

    public void removeIndex(int pos) {
        var current = head;
        for (int x = 0; x < pos - 1; x++) {
            if (current.mynext == null) {
                removeLast();
                return;
            }
            current = current.mynext;
        }
        current.mynext = current.mynext.mynext;
    }

    public void removeLast() {
        if (head == null) {
            return;
        }
        var current = head;
        while (current.mynext != null) {
            current = current.mynext;
        }
        current = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int countLess10() {
        var current = head;
        int count = 0;
        while (current != null) {
            if (current.data < 10) {
                count++;
            }
            current = current.mynext;
        }
        return count;
    }

    public int getByIndex(int pos) {
        var current = head;
        for (int x = 0; x < pos; x++) {  
            if (current.mynext == null) {
                return -1;
            }
            current = current.mynext;
        }
        return current.data;
    }

    public int getFirst() {
        return head.data;
    }
    
    public int getLast() {
        var current = head;
        while (current.mynext != null) {
            current = current.mynext;
        }
        return current.data;
    }

    public int getCount() {
        var current = head;
        int count = 0;
        while (current.mynext != null) {
            count++;
            current = current.mynext;
        }
        return count;
    }

    public void print() {
        var current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.mynext;
        }
        System.out.println("]");
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node current = head;

            public boolean hasNext() {
                return current != null;
            }

            public Integer next() {
                int data = current.data;
                current = current.mynext;
                return data;
            }
        };
    }
}
