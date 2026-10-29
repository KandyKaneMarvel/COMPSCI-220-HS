package DataStructures;

import java.util.Iterator;

public class CircularLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private class Node {
        T data;
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
    private int size;

    public CircularLinkedList() {
        head = null;
        size = 0;
    }

    public void add(T element) {
        var node = new Node(element);
        if (head == null) {
            head = node;
            head.mynext = head;
        } else {
            Node current = head;
            while (current.mynext != head) {
                current = current.mynext;
            }
            current.mynext = node;
            node.mynext = head;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        var current = head;
        if (index == 0) {
            while (current.mynext != head) {
                current = current.mynext;
            }
            head = head.mynext;
            current.mynext = head;
        } else {
            for (int x = 0; x < index - 1; x++) {
                current = current.mynext;
            }
            current.mynext = current.mynext.mynext;
        }
        size--;
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
        var current = head;
        do {
            System.out.print(current.data + ", ");
            current = current.mynext;
        } while (current != head);
        System.out.println("]");
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node current = head;
            private int index = 0;

            public boolean hasNext() {
                return index < size;
            }

            public T next() {
                T data = current.data;
                current = current.mynext;
                index++;
                return data;
            }
        };
    }
}
