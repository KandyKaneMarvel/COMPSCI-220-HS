package DataStructures;

import java.util.Iterator;

public class DoublyLinkedList <T extends Comparable<T>> implements Iterable<T> {
    private class Node {
        T data;
        Node prev;
        Node mynext;

        Node(T value) {
            data = value;
            mynext = null;
        }

        public int compareTo(Node a) {
            return data.compareTo(a.data);
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /** add to tail */
    public boolean add(T element) {
        var node = new Node(element);
        if (head == null) {
            head = node;
        } else {
            tail.mynext = node;
            node.prev = tail;
        }
        tail = node;
        size++;
        return true;
    }

    public void addFront(T element) {
        var node = new Node(element);
        if (head != null) {
            node.mynext = head;
            head.prev = node;
        }
        head = node;
        size++;
    }

    public void insert(int index, T element) {
        //todo
    }

    public void addSorted(T element) {
        //todo
    }

    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        //todo
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        var current = head;
        for (int x = 0; x < index; x++) {
            current = current.mynext;
        }
        return current.data;
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        var current = head;
        for (int x = 0; x < index; x++) {
            current = current.mynext;
        }
        current.data = element;
    }

    public void print() {
        System.out.print("[");
        for (Node current = head; current != null; current = current.mynext) {
            System.out.print(current.data + ", "); 
        }
        System.out.println("]");
    }

    public void printReverse() {
        System.out.print("[");
        for (Node current = tail; current != null; current = current.prev) {
            System.out.print(current.data + ", "); 
        }
        System.out.println("]");
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void removeItem(T item) {
        //todo
    }

    public T pop() {
        //todo, remove tail and return it
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                var data = current.data;
                current = current.mynext;
                return data;
            }
        };
    }
}
