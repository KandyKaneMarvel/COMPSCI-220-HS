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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFront(element);
            return;
        }
        var current = head;
        for (int x = 0; x < index; x++) {
            current = current.mynext;
        }
        var node = new Node(element);
        node.mynext = current;
        node.prev = current.prev;
        current.prev = node;
        size++;
    }

    public void addSorted(T element) {
        var node = new Node(element);

        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        if (head.compareTo(node) > 0) {
            node.mynext = head;
            head.prev = node;
            head = node;
            return;
        }

        for (var current = head; current != null; current = current.mynext) {
            if (current.compareTo(node) > 0) {
                node.mynext = current;
                node.prev = current.prev;
                node.prev.mynext = node;
                current.prev = node;
                return;
            }
        }

        node.mynext = tail;
        tail.prev = node;
        tail = node;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.mynext;
            if (head != null) {
                head.prev = null;
            }
            this.size--;
            return;
        }
        var current = head;
        for (int x = 0; x < index - 1; x++) {
            current = current.mynext;
        }
        current.mynext = current.mynext.mynext;
        if (current.mynext != null) {
            current.mynext.prev = current;
        }
        this.size--;
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
        var current = head;
        while (!current.data.equals(item)) {
            current = current.mynext;
            if (current == null) {
                return;
            }
        }
        if (current == head) {
            head = head.mynext;
            if (head != null) {
                head.prev = null;
            }
            this.size--;
            return;
        }
        
        if (current.prev != null) {
            current.prev.mynext = current.mynext;
        }
        if (current.mynext != null) {
            current.mynext.prev = current.prev;
        }
    }

    public T pop() {
        if (tail == null) {
            return null;
        }
        T data = tail.data;
        tail = tail.prev;
        size--;
        return data;
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
