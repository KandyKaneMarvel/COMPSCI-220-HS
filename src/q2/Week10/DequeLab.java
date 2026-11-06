package q2.Week10;

import DataStructures.Deque;

public class DequeLab {
    public static void main(String[] args) {
        var deq = new Deque<Integer>();
        for (int i = 0; i < 10; i++) {
            deq.enqueueFront(i);
        }
        for (int i = 0; i < 10; i++) {
            deq.enqueueRear(i);
        }

        System.out.println(deq.size());
        System.out.println(deq.peekFront());
        System.out.println(deq.peekRear());
        System.out.println(deq.dequeueFront());
        System.out.println(deq.dequeueRear());
        System.out.println(deq.size());

        var rand = new java.util.Random(42);
        for (int i = 0; i < 50; i++) {
            deq.enqueueFront(rand.nextInt(50));
        }
        for (int i = 0; i < 50; i++) {
            deq.dequeueFront();
        }

        System.out.println("New Size: " + deq.size());
        System.out.println(deq.peekFront());
        System.out.println(deq.peekRear());
    }
}
