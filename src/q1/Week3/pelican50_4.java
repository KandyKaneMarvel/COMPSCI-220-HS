package q1.Week3;

import Algorithms.SearchAlgorithms;

public class pelican50_4 {
    public static void main(String args[]) { 
        Integer[] list = {-7, 15, 21, 22, 43, 49, 51, 67, 78, 81, 84, 89, 95, 97};
 
        System.out.println(SearchAlgorithms.binarySearch(list, 22)); //3 
        System.out.println(SearchAlgorithms.binarySearch(list, 89)); //11
        System.out.println(SearchAlgorithms.binarySearch(list, -100)); //-1 
        System.out.println(SearchAlgorithms.binarySearch(list, 72)); //-1 
        System.out.println(SearchAlgorithms.binarySearch(list, 102)); //-1 
    } 
 
    
}
/*
3
11
-1
-1
-1
 */