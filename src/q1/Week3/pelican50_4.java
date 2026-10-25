package q1.Week3;

import Algorithms.*;

public class pelican50_4 {
    public static void main(String args[]) { 
        Integer[] iw = {-7, 15, 21, 22, 43, 49, 51, 67, 78, 81, 84, 89, 95, 97};
 
        System.out.println(SearchAlgorithms.binarySearch(iw, 22)); //3 
        System.out.println(SearchAlgorithms.binarySearch(iw, 89)); //11
        System.out.println(SearchAlgorithms.binarySearch(iw, -100)); //-1 
        System.out.println(SearchAlgorithms.binarySearch(iw, 72)); //-1 
        System.out.println(SearchAlgorithms.binarySearch(iw, 102)); //-1 
    } 
 
    
}