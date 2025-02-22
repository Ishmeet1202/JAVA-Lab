package Linked_list;

public class OnlyHeadMain {
    public static void main(String[] args) {
        DoublyLinkedListOnlyHead list = new DoublyLinkedListOnlyHead();

        list.insertFirst(12);
        list.insertFirst(3);
        list.insertFirst(99);
        list.insertFirst(45);

        list.insertLast(100);

//        list.insertAfter(100,99);
        list.insertAfter(102,100);

        list.display();
    }
}
