package Sorting;

public class CountingSort {

    private int[] arr = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};

    public CountingSort() {
        CountingSort(arr, 0, 10);
        for (int value:
                arr) {
            System.out.println(value);
        }
    }
    public void CountingSort(int[] input, int min, int max) {

        int[] countArray = new int[(max-min)+1];

        for (int i = 0; i < input.length; i++) {
            // example: i equals to 5
            // we would like to increment index 4 in the countarray
            countArray[input[i] - min]++;
        }

        //write values back to the input array
        // j used
        int j = 0;

        for(int i = min; i <= max; i++) {
            while(countArray[i - min] > 0) {
                // increment j with 1
                input[j++] = i;
                // decrement j with 1, since we just added 1 of the values.
                countArray[i - min]--;
            }
        }

    }
}
