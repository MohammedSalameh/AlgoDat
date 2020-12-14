package Sorting;

public class Quicksort {

    public void Quicksort(int[] input, int start, int end) {
        if(end-start < 2) {
            return;
            //we have a 1 element array.
        }

        // will return the position of the pivot element, in the sorted array
        // whatever is returned anything less than pivotIndex is lower.
        int pivotIndex = partition(input, start, end);
        Quicksort(input, start, pivotIndex); // quick sort the left sub array
        Quicksort(input,pivotIndex+1, end);// quick sort the right sub array

    }

    private int partition(int[] input, int start, int end) {
        // THis is using the first element as the pivot
        int pivot = input[start];
        int i = start;
        int j = end;

        while (i < j) {

            //find elements that are less than the pivot
            // NOTE: Empty loop
            // using the loop to decrement j
            // continues until we find an element that is less than the pivot
            // or if j crosses i
            while (i < j && input[--j] >= pivot);

            // found the first element that is less than the pivot
            // move it to the front of the array
            if(i < j) {
                input[i] = input[j];
            }

            // find elements that are greater than the pivot
            // NOTE: empty loop
            // using the loop to increment i
            while(i < j && input[++i] <= pivot);

            // found the first element that is greater than the pivot
            // move it to the back of the array
            if(i < j) {
                input[j] = input[i];
            }
        }

        // finished moving elements to the left and right.
        // set pivot value to its correct position and return index value.
        input[j] = pivot;
        return j;
    }

}
