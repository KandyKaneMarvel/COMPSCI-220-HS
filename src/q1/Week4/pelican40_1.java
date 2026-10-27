package q1.Week4;

import java.util.Scanner;

import Algorithms.SortAlgorithms;

public class pelican40_1 {
    public static void main(String args[]) { 
        Integer arr[] = {4,2,5,1,3,18,0,9,6}; 
        Integer tempArr[] = {4,2,5,1,3,18,0,9,6};
        SortAlgorithms.bubbleSort(arr);
        
        System.out.println("----- Bubble Sort -----");
        for(int j = 0; j < arr.length; j++) { 
            System.out.print(arr[j] + " "); 
        } 
        System.out.println(" "); 

        arr = tempArr; 
        SortAlgorithms.insertionSort(arr);
        
        System.out.println("----- Insertion Sort -----");
        for(int j = 0; j < arr.length; j++) { 
            System.out.print(arr[j] + " "); 
        } 
        System.out.println(" "); 

        arr = tempArr;
        SortAlgorithms.selectionSort(arr);
        
        System.out.println("----- Selection Sort -----");
        for(int j = 0; j < arr.length; j++) { 
            System.out.print(arr[j] + " "); 
        } 
        System.out.println(" "); 

        arr = tempArr;
        SortAlgorithms.shellSort(arr);
        
        System.out.println("----- Shell Sort -----");
        for(int j = 0; j < arr.length; j++) { 
            System.out.print(arr[j] + " "); 
        } 
        System.out.println(" "); 
    }
}
/*
----- Bubble Sort -----
0 1 2 3 4 5 6 9 18  
----- Insertion Sort -----
0 1 2 3 4 5 6 9 18  
----- Selection Sort -----
0 1 2 3 4 5 6 9 18  
----- Shell Sort -----
0 1 2 3 4 5 6 9 18 
 */