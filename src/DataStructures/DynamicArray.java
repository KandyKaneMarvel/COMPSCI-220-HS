package DataStructures;
import java.util.Iterator;
import java.nio.channels.CompletionHandler;
import java.util.Arrays;
import Algorithms.*;


@SuppressWarnings({"unchecked", "unused", "rawtypes"})
public class DynamicArray<T extends Comparable<T>> implements Iterable<T> {
    private T[] arr;
    private int size;
    private int cap;
    private static final int DEFAULT_CAP = 16;

    public DynamicArray() {
        size = 0;
        cap = DEFAULT_CAP;
        arr = (T[]) new Comparable[cap];
    }

    private void resize(int newCap) {
        var newArr = (T[]) new Comparable[newCap];
        if (size >= 0) {
            System.arraycopy(arr, 0, newArr, 0, size);
        }
        arr = newArr;
        cap = newCap;
    }

    public void add (T n) {
        if (size == cap) {
            resize(2*cap);
        }
        arr[size] = n;
        size++;
    }

    public T remove(int index) {
        T element = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        if (size == cap/4) {
            resize(cap/2);
        }
        return element;
    }

    public T get(int index) {
        return arr[index];
    }

    public void set(int index, T element) {
        arr[index] = element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int indexOf(T element) {
        return SearchAlgorithms.linearSearch(arr, element);
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }
    
    public void sort() {
        SortAlgorithms.insertionSort(arr, size);
    }

    public Comparable[] toArray() {
        return Arrays.copyOf(arr, size);
    }

    public String toString() {
        return Arrays.toString(this.toArray());
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = 0;
            public boolean hasNext() {
                return index < size;
            }
            public T next() {
                return arr[index++];
            }
        };
    }
}
