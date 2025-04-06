
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HeapTree {

    public void heapify(ArrayList<Integer> a,int n) {
        for (int i = (n - 2)/2; i >= 0; i--) {
            adjust(a,i,n);
        }
    }

    public void insert(ArrayList<Integer> a,int n,int x) {
        int i = n;

        a.add(x);

        while (i > 0 && x > a.get((i - 1)/2)) {
            a.set(i,a.get((i-1)/2));
            i = (i - 1)/2;
        }
        a.set(i,x);
    }

    public int delete(ArrayList<Integer> a,int n) {
        int x = a.get(0);
        a.set(0, a.get(n-1));
        a.remove(n-1);
        adjust(a, 0, n-1);

        return x; 
    }

    public void adjust(ArrayList<Integer> a, int pos, int n) {
        int i = pos; int j = (2*i) + 1;

        while (j <= n-1) {
            if (j < n-1 && a.get(j) < a.get(j+1)) {
                j += 1;
            }

            if (a.get(i) < a.get(j)) {
                Collections.swap(a,i,j);
                i = j;
                j = 2*j + 1;
            }
            else {
                break;
            }
        }
    }

    public void heapSort(ArrayList<Integer> a,int n) {
        for (int i = (n-2)/2; i >= 0; i--) {
            adjust(a, i, n);
        }

        for (int i = n-1; i >= 1; i--) {
            Collections.swap(a, i, 0);
            adjust(a, 0, i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(30,60,10,20,15,35));

        HeapTree ht = new HeapTree();

        ht.heapify(arr,arr.size());

        System.out.println(arr);

        ht.insert(arr, arr.size(), 65);
        System.out.println(arr);

        // ht.delete(arr, arr.size());
        // System.out.println(arr);
        // System.out.println(arr);

        // ht.heapSort(arr, arr.size());
        // System.out.println(arr);
    }
}