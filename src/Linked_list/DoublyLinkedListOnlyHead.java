package Linked_list;

public class DoublyLinkedListOnlyHead {

    private Node head;
    private int size;

    public DoublyLinkedListOnlyHead() {
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);

        node.next = head;
        node.previous = null;
        if (head != null)
            head.previous = node;
        head = node;
        size++;
    }

    public void insertLast(int value) {
        Node node = new Node(value);

        if (head == null) {
            node.previous = null;
            head = node;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        node.next = null;
        node.previous = temp;
        temp.next = node;
        size++;
    }

    public void insertBetween(int value,int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        }
        if (index == size) {
            insertLast(value);
        }

        Node temp = head;

        for (int i = 1; i < index; i++) {  // Starting from 1 because 0 is already covered in head.
            temp = temp.next;
        }

        Node node = new Node(value,temp.next);
        temp.next = node;
        size++;
    }

    public void insertAfter(int value, int afterValue) {
        Node node = new Node(value);
        Node previousNode = findNode(afterValue);

        node.next = previousNode.next;
        previousNode.next = node;
        node.previous = previousNode;
        if (node.next != null) {
            node.next.previous = node;
        }
    }

    public Node findNode(int value) {
        Node node = head;

        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }

        return null;
    }

    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value+" <=> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node {
        private int value;
        private Node next;
        private Node previous;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
