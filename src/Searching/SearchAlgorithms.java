package Searching;

public class SearchAlgorithms {

    int[] array = {-22, -15, 1, 7, 20, 35, 55};


    public int linearSearch(int val) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public int iterativeBinarySearch(int val) {
        int start = 0;
        int end = array.length;

        while (start < end) {
            // if start is equals end, we have traversed the array
            // and havent found what we are looking for
            int midpoint = (start+end)/2;
            System.out.println("Midpoint = "+midpoint);
            if (array[midpoint] == val) {
                return midpoint;
            } else if (array[midpoint] < val) {
                // search the right part of the array
                start = midpoint + 1;
            } else {
                // search the left part of the array
                // midpoint is the end of the array
                // run from start to midpoint
                end = midpoint;
            }
        }
        return -1;
    }

    public int recursiveBinarySearch(int val) {
        return recursiveBinarySearch(0, array.length, val);
    }

    public int recursiveBinarySearch(int start, int end, int val) {
        if (start >= end) {
            return -1;
        }

        int midpoint = (start+end)/2;
        System.out.println("Midpoint = "+midpoint);
        if (array[midpoint] == val) {
            return midpoint;
        } else if (array[midpoint] < val) {
            return recursiveBinarySearch(midpoint+1, end, val);
        } else {
            return recursiveBinarySearch(start, midpoint, val);
        }
    }


}
