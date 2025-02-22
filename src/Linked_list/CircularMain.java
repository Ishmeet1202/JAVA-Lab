package Linked_list;

public class CircularMain {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.insert(23);
        list.insert(3);
        list.insert(19);
        list.insert(75);
        list.insert(17);

        list.display();

        list.delete(17);

        list.display();
    }
}
