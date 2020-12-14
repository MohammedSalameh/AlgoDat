package Lists;

public class IntegerLinkedList {

    private IntegerNode head;
    private int size;


    public void addToFront(Integer value) {
        IntegerNode node = new IntegerNode(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public IntegerNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        IntegerNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void insertSorted(Integer value) {
        // assumption: the list is sorted
        if (head == null  || head.getValue() >= value) {
            addToFront(value);
            size++;
            return;
        }

        // find the insertion point
        IntegerNode newNode = new IntegerNode(value);
        IntegerNode current = head;

        while (current.getNext() != null && current.getValue() <= newNode.getValue()) {
            current = current.getNext();
        }

        current.setNext(newNode);

//        // Udemy solution
//        if (head == null || head.getValue() >= value) {
//            //insert immediatly
//            addToFront(value);
//            size++;
//            return;
//        }
//
//        // find the insertion point
//        IntegerNode current = head.getNext();
//        IntegerNode prev = head; // previous pointer
//
//        while (current != null && current.getValue() < value) {
//            prev = current;
//            current = current.getNext();
//        }
//
//        // current is null or value is greater that current
//        IntegerNode node = new IntegerNode(value);
//        node.setNext(current); //set new node in front of current
//        prev.setNext(node);
//        size++;


    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
