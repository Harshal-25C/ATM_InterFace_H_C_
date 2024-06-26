// These is a Normal InterFace of ATM Server in Java Development...
// These Application was Developed by : [ Github Account = Harshal-25C ]

import java.util.Scanner;

class BankAccount 
{

    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 100000f;
    int transactions = 0;
    String transactionHistory = "";

    // BankAccount(String name, String userName, String password, String accountNo) {
    // this.name = name;
    // this.userName = userName;
    // this.password = password;
    // this.accountNo = accountNo;
    // }

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n>> Enter Your Name : \n");
        this.name = sc.nextLine();
        System.out.print("\n>> Enter Your Username : \n");
        this.userName = sc.nextLine();
        System.out.print("\n>> Enter Your Password : \n");
        this.password = sc.nextLine();
        System.out.print("\n>> Enter Your Account Number : \n");
        this.accountNo = sc.nextLine();
        System.out.println("\n[ Registration completed...kindly login please! ]\n");
        
    }

    public boolean login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while ( !isLogin ) {
            System.out.print("\n>> Enter Your Username : \n");
            String Username = sc.nextLine();
            if ( Username.equals(userName) ) {
                while ( !isLogin ) {
                    System.out.print("\n>> Enter Your Password : \n");
                    String Password = sc.nextLine();
                    if ( Password.equals(password) ) {
                        System.out.print("\n[ You're Login successfully! ]");
                        isLogin = true;
                    }
                    else {
                        System.out.println("\n**[ Incorrect Password! ]**");
                    }
                }
            }
            else {
                System.out.println("\n**[ Username not found ]**");
            }
        }

        
        return isLogin;
    }

    public void withdraw() {

        System.out.print("\n>> Enter amount to withdraw : \n");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {

            if ( balance >= amount ) {
                transactions++;
                balance -= amount;
                System.out.println("\n[ Withdraw Successfully ]");
                String str = amount + " Rs Withdrawed.\n";
                transactionHistory = transactionHistory.concat(str);

            }
            else {
                System.out.println("\n[ Insufficient Balance ]");
            }

        }
        catch ( Exception e) {
        }
        
    }

    public void deposit() {

        System.out.print("\n>> Enter amount to deposit : \n");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        try {
            if ( amount <= 100000f ) {
                transactions++;
                balance += amount;
                System.out.println("\n[ Successfully Deposited ]");
                String str = amount + " Rs deposited.\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else {
                System.out.println("\n**[ Sorry...Limit is 100000.00 ]**");
            }

        }
        catch ( Exception e) {
        }
        
    }

    public void transfer() {

        Scanner sc = new Scanner(System.in);
        System.out.print("\n>> Enter Receipent's Name : ");
        String receipent = sc.nextLine();
        System.out.print("\n>> Enter amount to transfer : ");
        float amount = sc.nextFloat();

        try {
            if ( balance >= amount ) {
                if ( amount <= 50000f ) {
                    transactions++;
                    balance -= amount;
                    System.out.println("\n**[ Successfully Transfered to " + receipent + " ]**");
                    String str = amount + " Rs transfered to " + receipent + ".\n";
                    transactionHistory = transactionHistory.concat(str);
                }
                else {
                    System.out.println("\n**[ Sorry...Limit is 50000.00 ]**");
                }
            }
            else {
                System.out.println("\n[ Insufficient Balance ]");
            }
        }
        catch ( Exception e) {
        }
        
    }

    public void checkBalance() {
        System.out.println("\n**[ $ Total Amount is : " + balance + " Rs. ]**");
    }

    public void transHistory() {
        if ( transactions == 0 ) {
            System.out.println("\n**[ Empty ]**");
        }
        else {
            System.out.println("\n---------------------------------\n");
            System.out.println("\n" + transactionHistory);
            System.out.println("\n---------------------------------\n");
        }
    }
}

public class Task_3 {


    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;
        Scanner sc = new Scanner(System.in);

        while ( !flag ) {
            try {
                
                input = sc.nextInt();
                flag = true;

                if ( flag && input > limit || input < 1 ) {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            }
            catch ( Exception e ) {
                System.out.println("Enter only integer value");
                flag = false;
            }
        };
        
        return input;
    }


    public static void main(String[] args) {

        System.out.println("\n~ WELCOME TO BOI ATM SYSTEM ~\n\n");
        System.out.println("1. Register \n2. Exit");
        System.out.print("\n~ Enter Your Choice : \n");
        int choice = takeIntegerInput(2);

        if ( choice == 1 ) {
            BankAccount b = new BankAccount();
            b.register();
            while(true) {
                System.out.println("\n1. Login \n2. Exit");
                System.out.print("\n~ Enter Your Choice : \n");
                int ch = takeIntegerInput(2);
                if ( ch == 1 ) {
                    if (b.login()) {
                        System.out.println("\n\n~ WELCOME BACK " + b.name + " ~\n");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("\n1. Withdraw \n2. Deposit \n3. Transfer \n4. Check Balance \n5. Transaction History \n6. Exit");
                            System.out.print("\n~ Enter Your Choice : \n");
                            int c = takeIntegerInput(6);
                            switch(c) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                }
                else {
                    System.exit(0);
                }
            }
        }
        else {
            System.exit(0);
        }



    }
}
