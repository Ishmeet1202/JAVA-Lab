
import java.util.*;

public class Person {

    String name;
    float weight, height;

    Person(String name, float weight, float height) {
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    float getBMI() {
        return weight / (height * height);
    }

    String getBMICategory() {
        float bmi = getBMI();
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    @Override
    public String toString() {
        return name + " - BMI: " + String.format("%.2f", getBMI()) + " - " + getBMICategory();
    }

    static void read(ArrayList<Person> list, int n) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name, weight (kg), height (m): ");
            String name = sc.next();
            float weight = sc.nextFloat();
            float height = sc.nextFloat();
            list.add(new Person(name, weight, height));
        }
    }

    static void print(ArrayList<Person> list) {
        for (Person p : list) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> persons = new ArrayList<>();

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        Person.read(persons, n);

        HeapSort hs = new HeapSort();
        hs.heapSort(persons, n);

        System.out.println("\nSorted by BMI:");
        Person.print(persons);
    }
}

class HeapSort {

    public void adjust(ArrayList<Person> a, int pos, int n) {
        int i = pos;
        int j = 2 * i + 1;

        while (j <= n - 1) {
            if (j < n - 1 && a.get(j).getBMI() < a.get(j + 1).getBMI()) {
                j++;
            }
            if (a.get(i).getBMI() < a.get(j).getBMI()) {
                Collections.swap(a, i, j);
                i = j;
                j = 2 * j + 1;
            } else {
                break;
            }
        }
    }

    public void heapSort(ArrayList<Person> a, int n) {
        for (int i = (n - 2) / 2; i >= 0; i--) {
            adjust(a, i, n);
        }

        for (int i = n - 1; i >= 1; i--) {
            Collections.swap(a, i, 0);
            adjust(a, 0, i);
        }
    }
}
