package Lists;

import Models.Employee;

import java.util.Iterator;
import java.util.LinkedList;

public class DoublyLinkedList {


    public DoublyLinkedList () {
        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
        System.out.println(list.isEmpty());
        Employee janeJones = new Employee("Jane", "Jones", 21);
        Employee johnDoe = new Employee("John", "Doe", 34);
        Employee marrySmith = new Employee("Marry", "Smith", 365);
        Employee mikeWilson = new Employee("Mike", "Wilson", 325);

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marrySmith);
        list.addToFront(mikeWilson);

        list.printList();
        System.out.println(list.getSize());

//        Employee billEnd = new Employee("Bill", "End", 78);
//        list.addToTail(billEnd);
//        list.printList();
//        System.out.println(list.getSize());
//
//        list.removeFromFront();
//        list.printList();
//        System.out.println(list.getSize());
//
//        list.removeFromEnd();
//        list.printList();
//        System.out.println(list.getSize());

//        JDKLinkedList();

        list.addBefore(new Employee("Mummi", "Snow", 344), johnDoe);
        list.printList();
        System.out.println(list.getSize());

        list.addBefore(new Employee("Mummi", "Snow", 344), marrySmith);
        list.printList();
        System.out.println(list.getSize());
    }

    public void JDKLinkedList() {
        // is implemented as alinked list with implementation of list and deque
        Employee janeJones = new Employee("Jane", "Jones", 21);
        Employee johnDoe = new Employee("John", "Doe", 34);
        Employee marrySmith = new Employee("Marry", "Smith", 365);
        Employee mikeWilson = new Employee("Mike", "Wilson", 325);

        LinkedList<Employee> list = new LinkedList<>();
        list.addFirst(janeJones);
        list.addFirst(johnDoe);
        list.addFirst(marrySmith);
        list.addFirst(mikeWilson);

        Iterator iter = list.iterator();
        System.out.print("HEAD -> ");
        while (iter.hasNext()) {
            System.out.print(iter.next());
            System.out.print("<=>");
        }
        System.out.println("null");

//        for(Employee employee : list) {
//            System.out.println(employee);
//        }

         Employee billEnd = new Employee("Bill", "End", 78);
         list.add(billEnd); // add method adds to the end
//         list.addLast(billEnd);

         iter = list.iterator();
         System.out.print("HEAD -> ");
         while (iter.hasNext()) {
             System.out.print(iter.next());
             System.out.print("<=>");
         }
         System.out.println("null");

         list.removeFirst();
         iter = list.iterator();
         System.out.print("HEAD -> ");
         while (iter.hasNext()) {
             System.out.print(iter.next());
             System.out.print("<=>");
         }
         System.out.println("null");

//         list.remove(); removes at the head
         list.removeLast();
         iter = list.iterator();
         System.out.print("HEAD -> ");
         while (iter.hasNext()) {
             System.out.print(iter.next());
             System.out.print("<=>");
         }
         System.out.println("null");

         // Circular linked list
    }



}

class EmployeeDoublyLinkedList {
    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);


        // set the new head to the front of the list and the old to the next from head.
        // when we start with an empty list next and previous points to null
        if (head == null) {
            tail = node;
        } else {
            head.setPrevious(node);
            node.setNext(head);
        }
        head = node;
        size++;
    }

    public void addToTail(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        if(tail == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }

        tail = node;
        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public EmployeeNode removeFromFront() {
        if(isEmpty()) {
            return null;
        }

        // WE are concerned about the head
        EmployeeNode removedNode = head;

        // Test to see if only 1 node is in the list
        if (head.getNext() == null) {
            tail = null;
        } else {
            // Because we are removing from the front
            // we dont need to set previous to removedNode.getPrevious. since its null
            head.getNext().setPrevious(null);
        }

        head = head.getNext();
        size--;
        removedNode.setNext(null);// clean up references
        return removedNode;
    }

    public EmployeeNode removeFromEnd() {
        // Jane <=> Bill we want to remove bill
        // check for empty list
        if (isEmpty()) {
            return null;
        }

        // concerned about the tail
        // only when we have 1 in the list
        EmployeeNode removedNode = tail;

        if (tail.getPrevious() == null) {
            // only 1 node in the list
            head = null;
        } else {
            // currently bill is pointing to jane, set to null
            tail.getPrevious().setNext(null);
        }
        // new tail is jane
        tail = tail.getPrevious();
        size--;
        removedNode.setPrevious(null);// clean up references
        return removedNode;
    }

    public boolean addBefore(Employee newEmployee, Employee existingEmployee) {
        // return true if you were able to successfully add the employee
        // into the list before the existing employee. Return false
        // if the existing employee doesn't exist in the list

        // add your code here
        if (isEmpty()) {
            return false;
        }


        EmployeeNode newNode = new EmployeeNode(newEmployee);

        if (existingEmployee == head.getEmployee()) {
            newNode.setNext(head);
            newNode.setPrevious(head.getPrevious()); //null
            head.setPrevious(newNode);
            head = newNode;
            size++;
            return true;
        }

        if (existingEmployee == tail.getEmployee()) {
            EmployeeNode prev = tail.getPrevious();
            tail.setPrevious(newNode);
            newNode.setNext(tail);
            newNode.setPrevious(prev);
            prev.setNext(newNode);
            size++;
            return true;
        }

        EmployeeNode current = head;
        while (current.getEmployee() != existingEmployee) {
            current = current.getNext();

            if (current.getEmployee() == existingEmployee) {
                EmployeeNode prev = current.getPrevious();
                prev.setNext(newNode);
                current.setPrevious(newNode);
                newNode.setNext(current);
                newNode.setPrevious(prev);
                size++;
                return true;
            }
        }

//        // Udemy solution
//        EmployeeNode current = head;
//        while (current != null && !current.getEmployee().equals(existingEmployee))  {
//            current = current.getNext();
//        }
//
//        if (current == null) {
//            return false;
//        }
//
//        newNode.setPrevious(current.getPrevious());
//        newNode.setNext(current);
//        current.setPrevious(newNode);
//        if (head == current) {
//            head = newNode;
//        } else {
//            newNode.getPrevious().setNext(newNode);
//        }
//
//        size++;
//
//        return true;
        return false;
    }


    public void printList() {
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" <=> ");
            current = current.getNext();
        }
        System.out.println(" null");
    }
}
