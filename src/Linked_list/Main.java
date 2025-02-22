package Linked_list;

public class Main {
    public static void main(String[] args) {
//        LinkedList list = new LinkedList();
//
//        list.insertFirst(3);
//        list.insertFirst(2);
//        list.insertFirst(8);
//        list.insertFirst(18);
//
//        list.insertLast(20);
//
//        list.insertBetween(18,3);
//
//        list.display();
//
//        list.deleteLast();
//        list.deleteBetween(3);
//
//        list.find(18);
//
//        list.display();

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(18);

        list.insertLast(99);

        list.display();
        list.displayReverse();
    }
}
