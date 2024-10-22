package Password;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<PasswordGenerator> passwordGenerators = new ArrayList<>();

        System.out.print("Enter the length of the password: ");
        int lengthOfPassword = sc.nextInt();

        if(lengthOfPassword >= 8 && lengthOfPassword <= 15){
            for(int i=0;i<15;i++) {
                PasswordGenerator passwordGenerator = new PasswordGenerator(lengthOfPassword);
                passwordGenerator.generateRandomPassword();
                passwordGenerators.add(passwordGenerator);
            }

            for(PasswordGenerator passwordGenerator: passwordGenerators){
                System.out.println(passwordGenerator.getPassword());
            }
        }
        else {
            System.out.println("Password length must be between 8 and 15.");
        }
    }
}
