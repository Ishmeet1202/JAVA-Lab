package Linked_List_Sir_Methods;

public class SingleLinkedListMain {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        list.create(3);
        list.display();

//        list.insert(99,0);
//        list.insert(100,2);

        list.delete(2);

        list.display();

        list.delete(0);

        list.display();

        list.delete(0);

        list.display();
    }
}
