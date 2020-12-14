package Sorting;

public class SelectionSort {

    private int[] arr = {20, 35, -15, 7, 55};

    public SelectionSort() {
        System.out.println("Selection Sort");
        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largest = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (arr[i] > arr[largest]) {
                    largest = i;
                }
            }

            swap(arr, largest, lastUnsortedIndex);
        }

        for (int item : arr) {
            System.out.println(item);
        }
        System.out.println("======================");
    }

    public void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
