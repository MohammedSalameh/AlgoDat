import Hashtable.ChainingHashtable;
import Hashtable.SimpleHashtable;
import Lists.ArrayList;
import Lists.DoublyLinkedList;
import Lists.IntegerLinkedList;
import Lists.SinglyLinkedList;
import Models.Employee;
import Queues.ArrayQueue;
import Sorting.BucketSort;
import Stacks.ArrayStack;
import Stacks.LinkedStack;

import java.lang.reflect.Array;
import java.util.ListIterator;
import java.util.SimpleTimeZone;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

//        Sorting.BubbleSort bs = new Sorting.BubbleSort();
//        Sorting.SelectionSort ss = new Sorting.SelectionSort();
//        Sorting.InsertionSort is = new Sorting.InsertionSort();
//        Sorting.ShellSort shs = new Sorting.ShellSort();

        int[] arr = {20, 35, -15, 7, 55, 1, -22};

//        new Sorting.Quicksort().Sorting.Quicksort(arr, 0, arr.length);
//        new Sorting.CountingSort();
//        new Sorting.RadixSort();
//        new Sorting.Mergesort();

//        new DoublyLinkedList();

//        IntegerLinkedList list = new IntegerLinkedList();
//        list.insertSorted(5);
//        list.insertSorted(4);
//        list.printList();
//        list.insertSorted(2);
//        list.printList();
//        list.insertSorted(1);
//        list.printList();

//        new ArrayStack(10);
//        new LinkedStack();
//        new ArrayQueue(5);

        new SimpleHashtable();

//        new ChainingHashtable();
//        new BucketSort();

    }




    static class ListNode {
        int val;
        ListNode next;
        ListNode () {
            ListNode n1 = new ListNode(4);
            ListNode n2 = new ListNode(2);
            ListNode n3 = new ListNode(1);
            ListNode n4 = new ListNode(3);
            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
            ListNode head = n1;
        }
        ListNode (int val) {this.val = val;}
        ListNode (int val, ListNode next) {this.val = val;this.next = next;}

    }


}
