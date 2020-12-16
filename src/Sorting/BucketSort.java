package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {

    private int[] input;

    public BucketSort () {
        input = new int[]{54, 46, 83, 66, 95, 92, 43};
        bucketSort(input);
        for (int val: input) {
            System.out.println(val);
        }
    }

    public void bucketSort(int[] input) {
        // create buckets
        List<Integer>[] buckets = new List[10];

        // create lists for each bucket
        for (int i = 0; i < buckets.length; i++) {
            // using linked lists for the buckets
//            buckets[i] = new LinkedList<Integer>();
            // using array list for the buckets
            buckets[i] = new ArrayList<Integer>();

        }

        // scatter the values
        for (int i = 0; i < input.length; i++) {
            buckets[hash(input[i])].add(input[i]);
        }

        // sort each bucket
        for (List bucket: buckets) {
            // Mergesort
            Collections.sort(bucket);
        }

        // merge
        // traverse buckets
        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            // traverse the arraylist
            for (int value: buckets[i]) {
                input[j++] = value;
            }
        }

    }

    private int hash(int value) {
        // division first
        // 55/10=5
        return value / (int)10;
    }



}
