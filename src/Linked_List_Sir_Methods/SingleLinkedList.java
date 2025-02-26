package Linked_List_Sir_Methods;

import java.util.Scanner;

public class SingleLinkedList {
    private Node head;
    private int size;

    public SingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void create(int n) {
        Scanner sc = new Scanner(System.in);
        Node temp = null;

        for (int i = 0; i < n; i++) {
            Node newNode = new Node();
            System.out.print("Enter the value of node: ");
            newNode.value = sc.nextInt();

            if (head == null) {
                head = newNode;
                newNode.next = null;
                temp = head;
            } else {
                if (temp != null) {
                    temp.next = newNode;
                    temp = temp.next;
                }
            }
            size++;
        }
    }

    public void delete(int index) {
        if (index < 0 || index >= size) throw new IllegalArgumentException("Invalid index !");
        if (head == null) throw new IllegalStateException("List is Empty !");

        if (index == 0) {
            if (size == 1) {
                head = null;
                size = 0;
                return;
            }
            head = head.next;
            size--;
            return;
        }

        Node temp = head;

        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public void insert(int value,int index) {
        if (index < 0 || index > size) throw new IllegalArgumentException("Invalid index !");

        Node newNode = new Node(value);

        // EMPTY LIST CONDITION
        if (head == null) {
            head = newNode;
            newNode.next = null;
            size++;
            return;
        }

        Node temp = head;

        // INSERTING AT HEAD POSITION
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        // INSERTING AT OTHER INDEX
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
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
        } while(node != null);
        System.out.println("END");
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
    }
}
