package q1.Week4;
import java.util.ArrayList;

import DataStructures.DynamicArray;

public class DynamicArrayLab {
    public static void main(String[] args) {
        System.out.println("---------- Dynamic Array ----------");
        var dArr = new DynamicArray<Integer>();
        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            dArr.add((int)(Math.random()*100000));
        }
        long end = System.nanoTime();
        System.out.println("Dynamic Array add: " + ((end - start)/1e6) + " ms");

        start = System.nanoTime();
        dArr.sort();
        end = System.nanoTime();
        System.out.println("Dynamic Array sort: " + ((end - start)/1e6) + " ms");

        start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            dArr.remove(0);
        }
        end = System.nanoTime();
        System.out.println("Dynamic Array delete: " + ((end - start)/1e6) + " ms");

        System.out.println("\n---------- Array List ----------");
        var arr = new ArrayList<Integer>();
        start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arr.add((int)(Math.random()*100000));
        }
        end = System.nanoTime();
        System.out.println("Array List add: " + ((end - start)/1e6) + " ms");

        start = System.nanoTime();
        arr.sort(null);
        end = System.nanoTime();
        System.out.println("Array List sort: " + ((end - start)/1e6) + " ms");

        start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arr.remove(0);
        }
        end = System.nanoTime();
        System.out.println("Array List delete: " + ((end - start)/1e6) + " ms");
    }
}
/*
---------- Dynamic Array ----------
Dynamic Array add: 23.82521 ms
Dynamic Array sort: 25200.458163 ms
Dynamic Array delete: 33201.569581 ms

---------- Array List ----------
Array List add: 13.622071 ms
Array List sort: 74.587038 ms
Array List delete: 482.077348 ms
 */