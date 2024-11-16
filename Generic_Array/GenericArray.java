package Generic_Array;

import java.util.Arrays;

@SuppressWarnings("unchecked")

public class GenericArray<T> {
    private final int INITIAL_CAPACITY = 5;
    private T[] genericArray;
    private int index;

    public GenericArray() {
        genericArray = (T[]) new Object[INITIAL_CAPACITY];
        index = 0;
    }

    public void resizeMax(){
        T[] tempArr = (T[]) new Object[genericArray.length*2];

        for(int i = 0;i < index;i++){
            tempArr[i] = genericArray[i];
        }
        genericArray = tempArr;
    }

    private void resizeMin() {
        T[] tempArr = (T[]) new Object[genericArray.length/2];

        for(int i = 0;i < index;i++){
            tempArr[i] = genericArray[i];
        }
        genericArray = tempArr;
    }

    public void add(T element){
        if(index == genericArray.length){
            resizeMax();
        }
        genericArray[index++] = element;
    }

    public void remove(int position){
        T[] tempArr = (T[]) new Object[genericArray.length];

        try{
            if(genericArray[position] == null) {
                System.out.println("No element present at " + position + " index.");
                return;
            }

            int k = 0;
            for(int i = 0;i < genericArray.length;i++){
                if(i == position){
                    continue;
                }
                tempArr[k++] = genericArray[i];
            }
            genericArray = tempArr;

            --index;
            if(index < (genericArray.length/2)){
                resizeMin();
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    public void search(T element){
        boolean flag = false;
        for(int i = 0;i < genericArray.length;i++){
            if(genericArray[i].equals(element)){
                System.out.println("Element found at index "+i+".");
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println(element+" not found in GenericArray.");
        }
    }

    public int size(){
        return genericArray.length;
    }

    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOf(genericArray,index));
    }
}
