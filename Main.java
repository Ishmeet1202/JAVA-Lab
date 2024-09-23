package Bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<BankAccount> customers = new ArrayList<>();
        customers.add(new BankAccount("Harry", "Potter", "The Cupboard under the Stairs 4,Privet Drive", "London", 352523, 0));
        customers.add(new BankAccount("Ron", "Weasley", "Outside the village of Ottery St Catchpole", "Devon", 422424, 0));

        // VARIABLES
        int acc_no;
        BankAccount customer;
        double amount;
        String ans = "y";
        int rec_accno; // Variable for entering recipient account no for transfer money

        while (ans.equals("y") || ans.equals("Y")) {
            // MENU

            // ENTERING ACCOUNT NUMBER
            System.out.print("Enter your account no: ");
            acc_no = sc.nextInt();
            sc.nextLine();  // Clear the newline left by nextInt()

            // Returning the object of class BankAccount which is related to entered account no
            customer = check(acc_no, customers);
            if (customer == null) {
                System.out.println("Invalid account number.");
            }
            else {
                System.out.print("\nWelcome "+customer.getFirstname()+" !");
                System.out.println("""
                        \n
                        Enter your Choice:
                        1. Deposit Money
                        2. Withdraw Money
                        3. Check Balance
                        4. Transfer Money
                        5. Show Details of my account.
                        \n""");

                int choice;
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();  // Clear the newline left by nextInt()

                switch (choice) {
                    // DEPOSIT
                    case 1:
                        System.out.print("Enter amount to be deposited: ");
                        amount = sc.nextDouble();
                        sc.nextLine();      // Clear the newline left by nextInt()
                        customer.deposit(amount);
                        break;
                    // WITHDRAW
                    case 2:
                        System.out.print("Enter amount to be withdrawn: ");
                        amount = sc.nextDouble();
                        sc.nextLine();      // Clear the newline left by nextInt()
                        customer.withdraw(amount);
                        break;
                    // CHECK BALANCE
                    case 3:
                        customer.checkBalance();
                        break;
                    // TRANSFER MONEY
                    case 4:
                        System.out.print("Enter the account number to which you want to transfer money: ");
                        // Entering Recipient Account number to which money is being transfer
                        rec_accno = sc.nextInt();
                        sc.nextLine();      // Clear the newline left by nextInt()
                        // Returning the object of recipient of class BankAccount
                        BankAccount recipient = check(rec_accno,customers);
                        if (recipient == null){
                            System.out.println("Invalid account number.");
                            break;
                        }
                        else{
                            System.out.print("Enter the amount: ");
                            // Entering the amount to be transfer
                            amount = sc.nextDouble();
                            sc.nextLine();      // Clear the newline left by nextInt()
                            customer.transfer(recipient,amount);
                            System.out.println("\nTransaction Completed !");
                            break;
                        }
                        // SHOW DETAILS
                    case 5:
                        customer.showDetails();
                        break;
                    default:
                        System.out.println("Invalid Choice.");
                }
            }
            System.out.print("\nDo you want to check another account (Y/N) ? ");
            ans = sc.nextLine();
            if(ans.equals("n") || ans.equals("N")){
                System.out.println("\nExited !");
                break;
            }
        }
    }

    static BankAccount check(int accno,ArrayList<BankAccount> customers) {
        for (BankAccount i : customers) {
            if(i.getAccountno() == accno){
                return i;
            }
        }
        return null;
    }
}
