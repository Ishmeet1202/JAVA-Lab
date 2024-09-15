package Bank;

public class BankAccount {
    static int unique  = 100000;
    int accountno;
    String firstname;
    String lastname;
    String address;
    String city;
    int pinno;
    String aadharno;
    String panno;
    double balance;

    public BankAccount(String firstname, String lastname, String address, String city, int pinno, String aadharno, String panno,double balance) {
        unique++;
        this.accountno = unique;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.pinno = pinno;
        this.aadharno = aadharno;
        this.panno = panno;
        this.balance = balance;
    }

    public BankAccount(String firstname, String lastname, String address, String city, int pinno, double balance) {
        unique++;
        this.accountno = unique;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.pinno = pinno;
        this.balance = balance;
    }

    void deposit(double amount){
        balance += amount;
    }

    void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            System.out.println(amount+" has been withdrawn from Acc no. "+accountno);
        }
        else{
            System.out.println("Your balance is less than the amount.");
        }
    }

    void checkBalance(){
        System.out.println("Your balance is: "+balance);
    }

    void transfer(BankAccount recipient,double amount){
        if(balance >= amount){
            balance -= amount;
            recipient.balance += amount;
        }
        else{
            System.out.println("Your balance is less than the amount.");
        }
    }

    void showDetails(){
        System.out.println("Your Account no. is: "+accountno);
        System.out.println("Your name is: "+firstname+" "+lastname);
        System.out.println("Your Address is: "+address);
        System.out.println("Your City is: "+city);
        System.out.println("Your Pincode is: "+pinno);
        System.out.println("Your Aadhar no. is: "+aadharno);
        System.out.println("Your PAN no. is: "+panno);
        System.out.println("Your Account balance is: "+balance);
    }
}
