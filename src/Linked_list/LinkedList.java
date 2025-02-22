package Linked_list;

import java.util.ArrayList;

public class LinkedList {

    private Node head;
    private Node tail;

    private int size;

    public LinkedList() {
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if(tail == null)
            tail = head;
        size++;
    }

    public void insertLast(int value) {
        if(tail == null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
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

    public void deleteFirst() {
        head = head.next;
        if (head == null)
            tail = null;
        size--;
    }

    public void deleteLast() {
        if (size == 1) {
            deleteFirst();
            return;
        }
        Node temp = head;

        while (temp.next != tail) {
            temp = temp.next;
        }
//        System.out.println(temp.value);
        tail = temp;
        tail.next = null;
        size--;
    }

    public void deleteBetween(int index) {
        if (index == 0)
            deleteFirst();
        if (index == size-1)
            deleteLast();

        Node previous =  getPrevoiusNode(index);

        previous.next = previous.next.next;
        size--;
    }

    // UTILITY METHOD
    private Node getPrevoiusNode(int index) {
        Node node = head;

        for (int i = 1; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public void display() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.value+" => ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    
    public void find(int value) {
        Node node = head;
        ArrayList<Integer> indexPosition = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (node.value == value) {
                indexPosition.add(i);
            }
            node = node.next;
        }

        if (indexPosition.isEmpty()) {
            System.out.println(value+" not found in the Linked List");
        } else {
            System.out.println(value+" found at the indexes "+indexPosition);
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
