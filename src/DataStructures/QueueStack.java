package DataStructures;

@SuppressWarnings("unchecked")
public class QueueStack<T extends Comparable<T>> extends Queue<T>{

    public QueueStack() {
        super();
    }

    public void enqueue(T element) {
        super.enqueue(element);
    }

    public void push(T element) {
        if (size == capacity) {
            resize(size*2);
        }
        front = (front - 1 + capacity) % capacity;
        queue[front] = element;
        size++;
    }

    public T dequeue() {
        return super.dequeue();
    }

    public T pop() {
        rear = (rear - 1 + capacity) % capacity;
        T element = queue[rear];
        size--;
        if (size == capacity / 4) {
            resize(capacity / 2);
        }
        return element;
    }

    public T peekFront() {
        return queue[front];
    }

    public T peekRear() {
        return queue[(rear - 1 + capacity) % capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    protected void resize(int newCapacity) {
        if (newCapacity < 1) {
            newCapacity = 1;
        }

        var newQueue = (T[]) new Comparable[newCapacity];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % capacity];
        }
        queue = newQueue;
        capacity = newCapacity;
        front = 0;
        rear = size;
    }
}
