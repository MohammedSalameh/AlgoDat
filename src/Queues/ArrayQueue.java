package Queues;

import Models.Employee;
import Stacks.ArrayStack;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ArrayQueue {

    private Employee[] queue;
    private int front; // keeps track of front
    private int back; // keeps track of back back

    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
        this.enqueue(new Employee("Jane", "Jones", 21));
        this.enqueue(new Employee("John", "Doe", 34));
        this.dequeue();
        this.enqueue(new Employee("Marry", "Smith", 365));
        this.dequeue();
        this.enqueue(new Employee("Mike", "Wilson", 325));
        this.dequeue();
        this.enqueue(new Employee("Bill", "End", 54));
        this.dequeue();
        this.enqueue(new Employee("Jane", "Jones", 21));

//        printQueue();
//        System.out.println(size());
        this.dequeue();

        System.out.println(isPalindrome("Was iT a car or a cat I saw"));
        System.out.println(isPalindrome("abccba"));
    }

    public ArrayQueue () {
        // JDK has poll instead of remove/dequeue
        // ArrayBlockingQueue, once capacity is met, cannot be resized, gets blocked until another thread comes and pops.
        // Used for producer consumer scenarios. Messages read in the order they are sent.
        // ConcurrentLinkedQueue, unbounded thread safe queue based on linked nodes.
        // SIZE() is not a constant time method
        // Also adding with addAll/multiple methods may not keep order atomically.
    }

    public boolean isPalindrome(String s) {
        LinkedList queue = new LinkedList();
        LinkedList stack = new LinkedList();
        String sentence = s.toLowerCase();

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if(c > 'a' && c <= 'z') {
                stack.addLast(c);
                queue.addFirst(c);
            }
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.removeFirst())) {
                return false;
            }
        }

        return true;
    }



    // When adding the front never changes, but back needs to be incremented
    public void enqueue(Employee employee) {
        if (size() == queue.length-1) {
            int numItems = size();
            Employee[] newArray = new Employee[2 * queue.length];
            // copy existing to new array and respect order
            // the queue.length-front is length: 5-3=2 so we have two at the end of the array
            // mike and bill
            System.arraycopy(queue, front, newArray,0, queue.length-front);
            // then we need to take care of the rest and start at newArray.length-1= index 2
            // and traverse to index 2 in the old array and copy over
            System.arraycopy(queue, 0, newArray, queue.length-1, back);

            queue = newArray;
            front = 0;
            back = numItems;
        }


        // 0 - jane
        // 1 -  john
        // 2 -    -back
        // 3 - mike - front
        // 4 - bill
        // if statement below makes sure we reuse the empty places in the array
        // when back: 4 and we add bill back is now NOT less than queue.length: 4
        // so we make back = 0

        // AFTER RESIZE
        // if we enter the case where back: 2 and front: 3
        // we need to unwrap the queue when resizing and make sure order is respected when resizing
        // 0 Mike
        // 1 bill
        // 2 jane
        // 3 john
        // 4 - back (next available position)

        queue[back] = employee;
        if (back < queue.length-1) {
            back++;
        } else {
            back = 0;
        }
    }

    // When removing the front changes, but back never changes
    public Employee dequeue() {
        // subtract front from back.
        // front 0 back 1 = 1-0 = 1
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        Employee employee = queue[front];
        queue[front++] = null;

        // optimization if we removed the only element
        if (size() == 0) {
            front = 0;
            back = 0;
        } else if (front == queue.length) {
            // 0 - jane
            // 1 -  john
            // 2 -    -back
            // 3 - mike - front
            // 4 - bill
            // if we remove mike front becomes 4
            // then pull off bill then front becomes 0
            front = 0;

        }


        return employee;
    }

    public Employee peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public int size () {
        // check if the queue has wrapped
        if (front <= back) {
            return back-front;
        } else {
            // if front: 3 and back: 2: 2-3 = -1 + 5 = 4
            return back-front + queue.length;
        }
    }

    public void printQueue() {
        if (front <= back) {
            for (int i = front; i<back; i++) {
                System.out.println(queue[i]);
            }
        } else {
            // first print the mike and bill
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            // then the rest from the beginning of the array
            for (int i = 0; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
    }

}
