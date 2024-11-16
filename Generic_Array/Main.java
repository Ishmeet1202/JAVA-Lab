package Generic_Array;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GenericArray<Object> ga = new GenericArray<>();
        String ans = "y";

        while(ans.equals("y") || ans.equals("Y")){
            System.out.println("""
                        \n
                        Enter your Choice:
                        1. Add element
                        2. Remove element
                        3. Search element
                        4. Size of array
                        5. Display array
                        \n""");

            int choice;
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.print("Enter an element: ");
                    Object element = sc.next();
                    sc.nextLine();
                    ga.add(element);
                    break;
                case 2:
                    System.out.print("Enter the index of element: ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    ga.remove(index);
                    break;
                case 3:
                    System.out.print("Enter the element you want to search ? ");
                    Object ele = sc.next();
                    sc.nextLine();
                    ga.search(ele);
                    break;
                case 4:
                    System.out.print("Size of array is: "+ga.size()+"\n");
                    break;
                case 5:
                    System.out.println("Generic Array: ");
                    System.out.println(ga);
                    break;
                default:
                    System.out.println("You entered wrong choice.");
            }

            System.out.print("Do you want to continue ? ");
            ans = sc.nextLine();
            if(ans.equals("n") || ans.equals("N")){
                System.out.println("Exited !");
                break;
            }
        }
    }
}
