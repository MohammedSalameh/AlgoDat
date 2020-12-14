package Sorting;

public class ShellSort {

    private int[] arr = {20, 35, -15, 7, 55, 1, -22};

    public ShellSort() {
        System.out.println("Shell Sort");

        for (int gap = arr.length / 2; gap > 0;  gap /=2) {

            for (int i = gap; i < arr.length; i++) {
                int newElement = arr[i];

                int j = i;

                while(j>=gap && arr[j-gap] > newElement) {
                    arr[j] = arr[j-gap];//swap 20 with 7
                    j -= gap;
                }

                arr[j] = newElement;
            }

        }

        for (int item : arr) {
            System.out.println(item);
        }
        System.out.println("======================");
    }

}
