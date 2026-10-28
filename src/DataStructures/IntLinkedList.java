package DataStructures;

import java.util.Iterator;

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

    public boolean contains(int n) {
        var current = head;
        while (current != null) {
            if (current.data == n) {
                return true;
            }
            current = current.mynext;
        }
        return false;
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

    public double avg() {
        var current = head;
        int avg = 0;
        int count = 0;
        while (current != null) {
            avg += current.data;
            count++;
            current = current.mynext;
        }
        return avg / count;
    }

    public int min() {
        var current = head;
        int min = head.data;
        while (current != null) {
            if (min > current.data) {
                min = current.data;
            }
            current = current.mynext;
        }
        return min;
    }

    public int max() {
        var current = head;
        int max = head.data;
        while (current != null) {
            if (max < current.data) {
                max = current.data;
            }
            current = current.mynext;
        }
        return max;
    }

    public int indexOfMax() {
        var current = head;
        int max = head.data;
        int index = 0;
        int count = 0;
        while (current != null) {
            if (max < current.data) {
                max = current.data;
                index = count;
            }
            current = current.mynext;
            count++;
        }
        return index;
    }

    public int lastIndexOfMax() {
        var current = head;
        int max = head.data;
        int index = 0;
        int count = 0;
        while (current != null) {
            if (max <= current.data) {
                max = current.data;
                index = count;
            }
            current = current.mynext;
            count++;
        }
        return index;
    }

    public void sort() {
        if (head == null || head.mynext == null) {
            return;
        }

        Node temp = new Node(0);
        Node current = head;

        while (current != null) {
            Node nextTemp = current.mynext;
            Node previous = temp;

            while (previous.mynext != null && previous.mynext.data < current.data) {
                previous = previous.mynext;
            }

            current.mynext = previous.mynext;
            previous.mynext = current;
            current = nextTemp;
        }
    }

    public int lose58() {
        var current = head;
        int count = 0;
        while (current.mynext != null) {
            if (current.mynext.data == 58) {
                current.mynext = current.mynext.mynext;
                count++;
            }
            current = current.mynext;
        }
        return count;
    }

    public int getEvenCount() {
        var current = head;
        int count = 0;
        while (current.mynext != null) {
            if (current.mynext.data % 2 == 0) {
                count++;
            }
            current = current.mynext;
        }
        return count;   
    }

    public void removeOdds() {
        var current = head;
        while (current.mynext != null) {
            if (current.mynext.data % 2 != 0) {
                current.mynext = current.mynext.mynext;
            }
            current = current.mynext;
        }
    }

    public void clear() {
        head = null;
    }

    public void print() {
        var current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data + ", ");
            current = current.mynext;
        }
        System.out.println("]\n");
    }

    public IntLinkedList getReverse() {
        var reverse = this;
        var current = head;
        while (current != null) {
            reverse.addFront(current.data);
            current = current.mynext;
        }
        return reverse;
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
