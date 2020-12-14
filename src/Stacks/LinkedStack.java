package Stacks;

import Models.Employee;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class LinkedStack {

    private LinkedList<Employee> stack; // doubly linked list but methods below constraints its behaviour to singly
    private LinkedList<Character> stringStack;

    public LinkedStack() {
        stack = new LinkedList<>();
        stringStack = new LinkedList<>();
//        this.push(new Employee("Jane", "Jones", 21));
//        this.push(new Employee("John", "Doe", 34));
//        this.push(new Employee("Marry", "Smith", 365));
//        this.push(new Employee("Mike", "Wilson", 325));
//        this.push(new Employee("Bill", "End", 54));
//        this.pop();
////        printStack();
//        System.out.println(this.peek());
        System.out.println(isPalindrome("Was iT a car or a cat I saw?"));
        System.out.println(checkForPalindrome("Was iT a car or a cat I saw?"));
        System.out.println(isPalindrome("hello?"));
        System.out.println(checkForPalindrome("hello?"));
    }

    public void push(Employee employee) {
        stack.push(employee);
    }

    public Employee pop() {
        return stack.pop();
    }

    public Employee peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack() {
        ListIterator<Employee> iterator = stack.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public boolean isPalindrome(String s) {
        String trim = s.toLowerCase().replaceAll("[^A-z]", "").trim();
        char[] arr = trim.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= arr.length-1; i++) {
            stringStack.push(arr[i]);
        }

        ListIterator<Character> iterator = stringStack.listIterator();
        while (iterator.hasNext()) {
            sb.append(stringStack.pop());
        }

        if (sb.toString().equals(trim)) {
            return true;
        }

        return false;
    }

    public boolean checkForPalindrome(String s) {

        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder(s.length());
        String lowerCase = s.toLowerCase();

        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if(c > 'a' && c <= 'z') {
                sb.append(c);
                stack.push(c);
            }
        }

        StringBuilder reverseSB = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            reverseSB.append(stack.pop());
        }

        return reverseSB.toString().equals(sb.toString());
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();

        for (int i = 0; i <= charArr.length-1; i++) {
            if (stack.isEmpty()) {
                stack.push(charArr[i]);
            } else {
                if (stack.peek() == '(' && charArr[i] == ')') {
                    stack.pop();
                } else if (stack.peek() == '{' && charArr[i] == '}') {
                    stack.pop();
                } else if (stack.peek() == '[' && charArr[i] == ']') {
                    stack.pop();
                } else {
                    stack.push(charArr[i]);
                }
            }

        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }

}
