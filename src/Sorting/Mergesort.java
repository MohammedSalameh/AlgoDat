package Sorting;

public class Mergesort {

    private int[] arr = {20, 35, -15, 7, 55, 1, -22};


    public Mergesort() {
        Mergesort(arr, 0, arr.length);
        for ( int value : arr) {
            System.out.println(value);
        }
    }

    // {20, 35, -15, 7, 55, 1, -22}
    public void Mergesort(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
            //we have a 1 element array.
        }

        // end is going be greater than the last valid index: 7
        int mid = (start + end) / 2;
        Mergesort(input, start, mid);//left array
        Mergesort(input, mid, end);// right array
        merge(input, start, mid, end);
    }

    public void merge(int[] input, int start, int mid, int end) {

        // descending order use >=
        if (input[mid-1] <= input[mid]) {
            return;
            //mid-1 is the last element in the left partition
            //mid is the first element in the right partition
            //if true, then the array is sorted leave it as is
        }

        int i = start;
        int j = mid;
        int tempIndex = 0; //keep track of where we are in the temporary array

        int[] temp = new int[end-start];//7-0

        while( i < mid && j < end) {
            // descending order use >=
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        // any left over elements in the right array (no need to handle)
        // { 32, 34 }, { 33, 36 }
        // { 32, 33, 34 } leftover is 36, and is greater than all left elements. no need to overwrite 36 in the original array.

        // handle any left over elements in the left array (NEED TO HANDLE)
        // { 32, 36 }, { 33, 34 }
        // { 32, 33, 34, 36 } leftover is 36, and is greater than every number. so we need to move it to the correct index

        // if there are NO left over elements in left array this wont do anything
        // it there are left over elements in the left array, this will copy the elements to the correct index
        System.arraycopy(input, i, input, start + tempIndex, mid-i);

        // copy the temp array, to original
        System.arraycopy(temp, 0, input, start, tempIndex);


        // PEN AND PAPER WILL HELP


    }



}
