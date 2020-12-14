package Sorting;

public class BubbleSort {
    //STABLE SORT
    private int[] arr = {20, 35, -15, 7, 55};


    public BubbleSort() {
        System.out.println("Bubble Sort");
        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
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
