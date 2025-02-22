package Linked_list;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);

        node.next = head;
        node.previous = null;
        if (tail == null) {
            tail = head;
        }
        if (head != null)
            head.previous = node;
        head = node;
        size++;
    }

    public void insertLast(int value) {
        if (tail == null) {
            insertFirst(value);
        }

        Node node = new Node(value);

        node.previous = tail;
        node.next = null;
        tail.next = node;
        tail = node;
        size++;
    }



    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value+" <=> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void displayReverse() {
        Node temp = tail;

        while(temp != null) {
            System.out.print(temp.value+" <=> ");
            temp = temp.previous;
        }
        System.out.println("START");
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
    }
}
