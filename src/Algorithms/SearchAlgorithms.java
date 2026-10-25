package Algorithms;

public class SearchAlgorithms {
    public static <T extends Comparable<T>> int linearSearch(T[] arr, T target) {
        for (int x = 0; x < arr.length; x++) {
            if (arr[x].compareTo(target) == 0) {
                return x;
            }
        }
        return -1;
    }

    public static <T extends Comparable<T>> int binarySearch(T[] arr, T target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid].compareTo(target) == 0) {
                return mid;
            }
            if (arr[mid].compareTo(target) <= 0) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static <T extends Comparable<T>> int binarySearchRecursive(T[] arr, T target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }

    public static <T extends Comparable<T>> int binarySearchRecursive(T[] arr, T target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (arr[mid].compareTo(target) == 0) {
            return mid;
        } else if (arr[mid].compareTo(target) < 0) {
            return binarySearchRecursive(arr, target, mid+1, high);
        }
        return binarySearchRecursive(arr, target, low, mid-1);
    }
}
