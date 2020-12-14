package Stacks;

import Models.Employee;

import java.util.EmptyStackException;

public class ArrayStack {

    private Employee[] stack;
    private int top; // size of the array always starts at 1 if not empty

    public ArrayStack(int capacity) {
        stack = new Employee[capacity];
        this.push(new Employee("Jane", "Jones", 21));
        this.push(new Employee("John", "Doe", 34));
        this.push(new Employee("Marry", "Smith", 365));
        this.push(new Employee("Mike", "Wilson", 325));
        this.push(new Employee("Bill", "End", 54));

//        stack.printStack();

        System.out.println("POPPED: " + this.pop());
        this.printStack();
    }

    public void push(Employee employee) {
        if (top == stack.length) {
            // we are out of bounds (array is full)
            // resize backing array O(n)
            Employee[] newArray = new Employee[2 * stack.length];
            System.arraycopy(stack, 0, newArray,0, stack.length);
            stack = newArray;
        }

        stack[top++] = employee;
    }

    public Employee pop () {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // O(1)
        // top holds empty spot, decrement to access Last item
        Employee employee = stack[--top];
        stack[top] = null;
        return employee;
    }

    public Employee peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // we do not decrement here
        // not changing anything
        return stack[top-1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size () {
        return top;
    }

    public void printStack() {
        for (int i = top-1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
