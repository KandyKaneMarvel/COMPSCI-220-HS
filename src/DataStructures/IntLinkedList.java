package DataStructures;

import java.util.Iterator;

/*
public int getCount()
public boolean add(int n, int pos) (random num 1-200)

public int getByIndex(int pos)  (-1 if illegal position)
public void removeFirst()
public void removeLast()
public int countLess10()
public void removeIndex(int pos)
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
        //i prefer mynext more so i'll be using that
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

    public void addlast(int data) {
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

    public boolean isEmpty() {
        return head == null;
    }

    public int getFirst() {

    }
    
    public int getLast() {
        
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
