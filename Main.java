package Bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<BankAccount> customers = new ArrayList<BankAccount>();
        customers.add(new BankAccount("Kunal", "Kushwaha", "Tibra Road", "Modinagar", 201204, 0));
        customers.add(new BankAccount("Arpit", "Bala", "Vada Pav Road", "Mumbai", 422424, 0));

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

            customer = check(acc_no, customers);     // Returning the object of class BankAccount which is related to entered account no
            if (customer == null) {
                System.out.println("Invalid account number.");
            }
            else {
                System.out.print("\nWelcome "+customer.firstname+" !");
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
                    case 1:     // DEPOSIT
                        System.out.print("Enter amount to be deposited: ");
                        amount = sc.nextDouble();
                        sc.nextLine();      // Clear the newline left by nextInt()
                        customer.deposit(amount);
                        break;
                    case 2:     // WITHDRAW
                        System.out.print("Enter amount to be withdrawn: ");
                        amount = sc.nextDouble();
                        sc.nextLine();      // Clear the newline left by nextInt()
                        customer.withdraw(amount);
                        break;
                    case 3:     // CHECK BALANCE
                        customer.checkBalance();
                        break;
                    case 4:     // TRANSFER MONEY
                        System.out.print("Enter the account number to which you want to transfer money: ");
                        rec_accno = sc.nextInt();       // Entering Recipient Account number to which money is being transfer
                        sc.nextLine();      // Clear the newline left by nextInt()
                        BankAccount recipient = check(rec_accno,customers); // Returning the object of recipient of class BankAccount
                        if (recipient == null){
                            System.out.println("Invalid account number.");
                            break;
                        }
                        else{
                            System.out.print("Enter the amount: ");
                            amount = sc.nextDouble();       // Entering the amount to be transfer
                            sc.nextLine();      // Clear the newline left by nextInt()
                            customer.transfer(recipient,amount);
                            System.out.println("\nTransaction Completed !");
                            break;
                        }
                    case 5:     // SHOW DETAILS
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
            if(i.accountno == accno){
                return i;
            }
        }
        return null;
    }
}
