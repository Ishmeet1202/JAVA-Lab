package Array;

import java.util.Arrays;

@SuppressWarnings("unchecked")

public class OneDArray <T> {
    private final T[] array;
    private final int len;
    private int size;

    public OneDArray(int len) {
        this.len = len;
        this.array = (T[]) new Object[this.len];
        this.size = 0;
    }

    public boolean isEmpty() {
        return array.length == 0;
    }

    public int getSize() {
        return size;
    }

    public void insert(T value,int index) {
        if (len == size) throw new IllegalStateException("Array is full !");
        if (index < 0 || index > len) throw new IllegalArgumentException("Invalid Index !");

        for (int i = size - 1; i >= index; i--) {
            array[i+1] = array[i];
        }
        array[index] = value;
        size += 1;
    }

//    public void insert(T value, int index) {
//        if (size == len) throw new IllegalStateException("Array is full!");
//        if (index < 0 || index >= len) throw new IllegalArgumentException("Invalid Index!");
//
//        // Shift elements to the right from `size - 1` to `index`
//        for (int i = size; i > index; i--) {
//            array[i] = array[i - 1];
//        }
//
//        array[index] = value; // Insert value at the specified index
//        size++;  // Increase size
//    }


    public void delete(int index) {
        if (size == 0) throw new IllegalStateException("Array is empty !");
        if (index < 0 || index >= size) throw new IllegalArgumentException("Invalid Index !");

        for (int i = index+1; i <= size - 1; i++) {
            array[i-1] = array[i];
        }
        size -= 1;
    }

    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value))
                return i;
        }
        return -1;
    }

    public T get(int index) {
        if (index >= size) throw new IllegalStateException("No element found at index "+index+" !");
        if (index < 0 || index >= len) throw new IllegalArgumentException("Invalid index !");

        return array[index];
    }

    public void display() {
        System.out.println(Arrays.toString(array));
    }

//    public void display() {
//        StringBuilder result = new StringBuilder("[");
//        for (int i = 0; i < size; i++) {
//            result.append(array[i]);
//            if (i < size - 1)
//                result.append(", ");
//        }
//        result.append("]");
//
//        System.out.println(result.toString());
//    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            if (i < size - 1)
                result.append(", ");
        }
        result.append("]");

        return result.toString();
    }
}
