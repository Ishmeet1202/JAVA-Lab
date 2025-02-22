package Linked_list;

public class CircularLinkedList {
    private Node head;
    private Node tail;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int value) {
        Node node = new Node(value);

        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        head = node;
    }

    public void delete(int value) {
        Node node = head;

        if (node == null)
            return;

        if (node.value == value) { // FOR HEAD DELETION
            head = head.next;
            tail.next = head;
            return;
        }


        while (node.next != head) {
            if (node.next == tail && tail.value == value) { // FOR TAIL DELETION
                node.next = head;
                tail = node;
                break;
            }

            if (node.next.value == value) {
                node.next = node.next.next;
                break;
            }

            node = node.next;
        }
    }

    public void display() {
        Node node = head;

        if (head != null) {
            do {
                System.out.print(node.value+" => ");
                node = node.next;
            } while (node != head);
            System.out.println("HEAD");
        }
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
