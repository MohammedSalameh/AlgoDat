package Sorting;

public class InsertionSort {

    private int[] arr = {20, 35, -15, 7, 55, 1, -22};

    public InsertionSort() {
//        RecursiveInsertionSort(arr,1);
        InsertionSort(arr, arr.length);

        for (int item : arr) {
            System.out.println(item);
        }
    }

    private void IterativeInsertionSort () {
        System.out.println("Insertion Sort");

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
            int newElement = arr[firstUnsortedIndex];

            int i;

            //first item we want to sort is at firstUnsortedIndex
            for (i = firstUnsortedIndex; i > 0 && arr[i-1] > newElement; i--) {
                //arr[i-1] > newElement we want to shift the higher value to the right
                arr[i] = arr[i-1];
            }

            arr[i] = newElement;

        }


        for (int item : arr) {
            System.out.println(item);
        }
        System.out.println("======================");
    }

    private void RecursiveInsertionSort (int[] input, int firstUnsortedIndex) {
        if (firstUnsortedIndex >= input.length) {
            System.out.println("end");
            return;
        }
        int newElement = input[firstUnsortedIndex];

        int i = firstUnsortedIndex;

        while (i > 0 && input[i-1] > newElement) {
            input[i] = input[i-1];
            i--;
        }

        input[i] = newElement;
        firstUnsortedIndex++;
        RecursiveInsertionSort(input, firstUnsortedIndex++);
        System.out.println("Result of call when firstUnsortedIndex = " + firstUnsortedIndex);
        for (i = 0; i < input.length; i++) {
            System.out.print(input[i]);
            System.out.print(", ");
        }
        System.out.println("");
        System.out.println("-------------------");

    }

    // Solution from course
    private void InsertionSort(int[] input, int numItems) {
        if (numItems < 2) {
            return;// 1 item is sorted
        }

        InsertionSort(input, numItems-1);

        int newElement = input[numItems-1];

        int i;

        //first item we want to sort is at firstUnsortedIndex
        for (i = numItems-1; i > 0 && input[i-1] > newElement; i--) {
            //arr[i-1] > newElement we want to shift the higher value to the right
            input[i] = input[i-1];
        }

        input[i] = newElement;
        System.out.println("Result of call when numItems = " + numItems);
        for (i = 0; i < input.length; i++) {
            System.out.print(input[i]);
            System.out.print(", ");
        }
        System.out.println("");
        System.out.println("-------------------");

    }


}
