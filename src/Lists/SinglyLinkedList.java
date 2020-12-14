package Lists;

import Models.Employee;

public class SinglyLinkedList {


    public SinglyLinkedList () {
        EmployeeLinkedList list = new EmployeeLinkedList();
        System.out.println(list.isEmpty());
        Employee jackNoir = new Employee("Jack", "Noir", 14);
        Employee janeJones = new Employee("Jane", "Jones", 21);
        Employee johnDoe = new Employee("John", "Doe", 34);
        Employee marrySmith = new Employee("Marry", "Smith", 365);
        Employee mikeWilson = new Employee("Mike", "Wilson", 325);


        list.addToFront(jackNoir);
        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marrySmith);
        list.addToFront(mikeWilson);

        list.printList();
        System.out.println(list.getSize());

        list.removeFromFront();
        System.out.println(list.getSize());
        list.printList();

    }



}


class EmployeeLinkedList {
    private EmployeeNode head;
    private int size;
    public void addToFront(Employee employee) {
        // set the new head to the front of the list and the old to the next from head.
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
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

        EmployeeNode removedNode = head;
        head.getNext();
        size--;
        removedNode.setNext(null);// clean up references
        return removedNode;
    }

    public void printList() {
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println(" null");
    }
}

class EmployeeNode {
    private Employee employee;
    private EmployeeNode next;
    private EmployeeNode previous; // for doubly linked list

    public EmployeeNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeNode getNext() {
        return next;
    }

    public void setNext(EmployeeNode next) {
        this.next = next;
    }

    public EmployeeNode getPrevious() {
        return previous;
    }

    public void setPrevious(EmployeeNode previous) {
        this.previous = previous;
    }

    public String toString() {
        return employee.toString();
    }
}
