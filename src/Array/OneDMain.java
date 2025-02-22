package Array;

public class OneDMain {
    public static void main(String[] args) {
        OneDArray<Integer> arr = new OneDArray<>(5);

        arr.insert(1,0);
        arr.insert(2,1);
        arr.insert(3,2);
        arr.insert(4,3);
        arr.insert(5,4);

        arr.display();
        System.out.println(arr.getSize());

        arr.delete(4);

        arr.display();
    }
}
