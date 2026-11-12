package DataStructures;

public class Deque<T extends Comparable<T>> extends Queue<T> {
    public Deque() {
        super();
    }

    public void enqueueFront(T element) {
        if (size == capacity) {
            resize(size*2);
        }
        front = (front - 1 + capacity) % capacity;
        queue[front] = element;
        size++;
    }

    public void enqueueRear(T element) {
        super.enqueue(element);
    }

    public T dequeueFront() {
        return super.dequeue();
    }

    public T dequeueRear() {
        rear = (rear - 1 + capacity) % capacity;
        T element = queue[rear];
        size--;
        if (size == capacity / 4) {
            resize(capacity / 2);
        }
        return element;
    }

    public T peekFront() {
        return super.peek();
    }

    public T peekRear() {
        return queue[(rear - 1 + capacity) % capacity];
    }
}
