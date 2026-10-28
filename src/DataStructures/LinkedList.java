package DataStructures;

public class LinkedList <T extends Comparable<T>> {
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

    public LinkedList() {
        head = null;
        size = 0;
    }

    public boolean add(T element) {
        var node = new Node(element);
        if (head == null) {
            head = node;
        } else {
            var current = head;
            while (current.mynext != null) {
                current = current.mynext;
            }
            current.mynext = node;
        }
        size++;
        return true;
    }

    public T remove(int index) {
        T old;

        if (index == 0) {
            old = head.data;
            head = head.mynext;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.mynext;
            }
            old = current.mynext.data;
            current.mynext = current.mynext.mynext;
        }
        size--;
        return old;
    }

    public T get(int index) {
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.mynext;
        }
        return current.data;
    }

    public T set(int index, T element) {
        T old;
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.mynext;
        }
        old = current.data;
        current.data = element;
        return old;
    }

    public void print() {
        System.out.print("[");
        for (Node current = head; current != null; current = current.mynext) {
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
}
