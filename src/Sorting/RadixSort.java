package Sorting;

public class RadixSort {

    int[] radixArray = {4725, 4586, 1330, 8792, 1594, 5729};


    public RadixSort() {
        RadixSort(radixArray, 10, 4);
    }

    public void RadixSort(int[] input, int radix, int width) {
        System.out.println("Sorting.RadixSort");
        for (int i = 0; i< width; i++) {
            // move from least significant digit to the most significant
            RadixSingleSort(input, i, radix);
        }

        for (int value: radixArray) {
            System.out.println(value);
        }
    }

    public void RadixSingleSort(int [] input, int position, int radix) {

        // No. of items to sort
        int numItems = input.length;

        int[] countArray = new int[radix]; // 0 - 9

        // COUNTING specific DIGITS at the specific position.
        for (int value: input) {
            // increment the value by 1 in countArray
            // example, the first digit will be 5 (4725), so we increment index 5 by one
            countArray[GetDigit(position, value, radix)]++;
        }

        // Stable sorting here.
        // everything in the array contains everything equals to or less than the index.
        for (int j = 1; j < radix; j++) {
             countArray[j] += countArray[j-1];
        }

        // copy the value into temporary array
        int[] temp = new int[numItems];
        for(int tempIndex = numItems-1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[GetDigit(position, input[tempIndex], radix)]] = input[tempIndex];
        }

        // copy to the input array
        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
    }

    public int GetDigit(int position, int value, int radix) {
        // value = 4725
        // radix = 10
        // position = 0
        // (4725 / 10^0 = 1) % 10 = 472

        //
        return value / (int) Math.pow(radix, position) % radix;
    }

}
