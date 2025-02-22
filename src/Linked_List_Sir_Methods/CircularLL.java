package Linked_List_Sir_Methods;

import java.util.Scanner;

public class CircularLL {
    private Node head;
    private int size;

    public CircularLL() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void create(int n) {
        Scanner sc = new Scanner(System.in);
        Node temp = null;
        size = n;

        for (int i = 0; i < n; i++) {
            Node newNode = new Node();
            System.out.print("Enter the value of node: ");
            newNode.value = sc.nextInt();
            if (head == null) {
                head = newNode;
                newNode.next = head;
                temp = head;
            } else {
                if (temp != null) {
                    temp.next = newNode;
                    newNode.next = head;
                    temp = temp.next;
                }
            }
        }
        sc.close();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(int value,int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Invalid Index !");

        Node newNode = new Node(value);

        // FOR INSERTING IN AN EMPTY LIST
        if (head == null) {
            head = newNode;
            newNode.next = head;
            size++;
        } else {

            Node temp = head;
            // FOR INSERTING AT HEAD (i.e. 0th) INDEX
            if (index == 0) {
                while (temp.next != head){
                    temp = temp.next;
                }
                newNode.next = head;
                temp.next = newNode;
                head = newNode;
                size++;
                return;
            }

            // INSERTING AT OTHER POSITIONS
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    public void delete(int index) {
        if (head == null) throw new IllegalStateException("List is Empty");

        if (index < 0 || index >= size) throw new IllegalArgumentException("Invalid Index !");

        Node temp = head;

        // DELETING HEAD (i.e. 0th INDEX).
        if (index == 0) {
            if (size == 1) {
                head = null;
                return;
            }
            else {
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = head.next;
                head = temp;
                size--;
                return;
            }
        }

        // DELETING AT OTHER POSITIONS
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public int indexOf(int value) {
        int index = 0;
        Node temp = head;

        do {
            if (temp.value == value) {
                return index;
            }
            index++;
            temp = temp.next;
        } while (temp != head);

        return -1;
    }

    public int get(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Invalid Index !");

        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.value;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is Empty !");
            return;
        }

        Node node = head;

        do {
            System.out.print(node.value+" => ");
            node = node.next;
        } while(node != head);
        System.out.println("HEAD");
    }

    private class Node {
        private int value;
        private Node next;

        public Node() {
            this.next = null;
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
