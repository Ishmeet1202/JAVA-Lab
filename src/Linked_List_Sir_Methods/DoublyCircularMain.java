package Linked_List_Sir_Methods;

public class DoublyCircularMain {
    public static void main(String[] args) {
        DoublyCircularLL list = new DoublyCircularLL();

        list.create(4);

        list.display();

//        list.insert(10,0);
//        list.insert(100,2);
//

//        list.delete(0);
//        list.display();
//
//        list.delete(2);
//        list.display();

        System.out.println(list.indexOf(3));
        System.out.println(list.get(0));
    }
}
