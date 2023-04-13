package Lab6;

import java.util.Scanner;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;


public class Lab6 {
    public static void main(String[] args) throws FileNotFoundException
    {
        ATM.setAvailable(4000);
        ATM.setMax(5000);
        ATM.authenticate();
    }
}

class ClientAccount
{
    private String name,pin;
    private int account,balance;
    public ClientAccount()
    {
        name = "Unknown";
        pin = "Unknown";
        account = 0;
        balance = 0;
    }

    public ClientAccount(String n, String p, int a, int b)
    {
        name = n;
        pin = p;
        account = a;
        balance = b;
    }

    public void setName(String n)
    {
        name = n;
    }

    public String getName()
    {
        return name;
    }
    
    public void setPin(String p)
    {
        pin = p;
    }

    public String getPin()
    {
        return pin;
    }

    public void setAccount(int a)
    {
        account = a;
    }

    public int getAccount()
    {
        return account;
    }

    public void setBalance(int b)
    {
        balance = b;
    }

    public int getBalance()
    {
        return balance;
    }

    
    public void deposit(double dep)
    {
        if (ATM.canDeposit(dep))
        {
            balance += dep;
            ATM.setAvailable(ATM.getAvailable() + dep);
            System.out.println(name + " has deposited " + dep + " AED");
        }
        else
        {
            System.out.println("Dear " + name + " you cant deposit to this account, ATM is full");
        }
    }
    
    public void withdraw(double with)
    {
        if (ATM.canWithdraw(with))
        {
            balance -= with;
            ATM.setAvailable(ATM.getAvailable() - with);
            System.out.println(name + " has withdrawn " + with + " AED");
        }
        else
        {
            System.out.println("Dear " + name + " you dont have available fund in your balance");
        }
    }

    public void displayBalance()
    {
        System.out.println(balance);
    }
    
    public String toString()
    {
        return "Name: " + name + ", Account Number: " + account + ", Balance: " + balance;
    }

    public void options() throws FileNotFoundException
    {
        PrintWriter fout = new PrintWriter("Account" + getAccount());
        Scanner con = new Scanner(System.in);
        System.out.println("Enter The Number of Transactions To Do. ");
        System.out.println("1) Withdraw 100 AED");
        System.out.println("2) Withdraw 200 AED");
        System.out.println("3) Withdraw 300 AED");
        System.out.println("4) Withdraw other amount");
        System.out.println("5) Deposit");
        System.out.println("6) Print Balance");
        System.out.println("7) Exit");
        boolean flag = true;

        do{
            int num = con.nextInt();
            switch(num)
            {''
                case 1:
                withdraw(100);
                fout.println("Withdrawal:100 AED");
                break;
                case 2:
                withdraw(200);
                fout.println("Withdrawal:200 AED");
                break;
                case 3:
                withdraw(300);
                fout.println("Withdrawal:300 AED");
                break;
                case 4:
                System.out.println("Enter the amount you would like to withdraw: ");
                double w = con.nextDouble();
                withdraw(w);
                fout.println("Withdrawal:" + w + " AED");
                break;
                case 5:
                System.out.println("Enter the amount you would like to deposit: ");
                double d = con.nextDouble();
                deposit(d);
                fout.println("Deposit:" + d + " AED");
                break;
                case 6:
                System.out.println("your available balance is " + getBalance() + " AED");
                break;
                case 7:
                System.out.println("Goobdye");
                ATM.logout();
                flag = false;
            }
        }while(flag);
        fout.close();
        con.close();
    }
}

class ATM
{
    private static double available,max;
    private static ClientAccount activeAccount;

    public static void authenticate() throws FileNotFoundException
    {
        Scanner console = new Scanner(System.in);
        boolean flag = false;
        int count = 0;
        String a = "";
        String b = "";
        int c = 0;
        int d = 0;
        do{

            Scanner fin = new Scanner (new FileReader("Users.txt"));
            System.out.println("Enter name and password");
            String nn = console.next();
            String pp = console.next();

            while (fin.hasNext()){
                a = fin.next();
                b = fin.next();
                c = fin.nextInt();
                d = fin.nextInt();

                if (nn.equals(a) && pp.equals(b))
                {
                    activeAccount = new ClientAccount(a,b,c,d);
                    activeAccount.options();
                    flag = true;
                    break;
                }
            }
            if (nn.equals(a) && pp.equals(b)) break;
            if (flag==false){count++;}
            else{System.out.println("Error"); break;}
            fin.close();
            
        }while(count<3);
        console.close();
    }

    public static void setAvailable(double av)
    {
        available = av;
    }

    public static double getAvailable()
    {
        return available;
    }

    public static void setMax(double m)
    {
        max = m;
    }

    public static double getMax()
    {
        return max;
    }

    public static boolean canWithdraw(double with){ return (available >= with);}

    public static boolean canDeposit(double dep){ return (max >= dep + available);}

    public static void logout() throws FileNotFoundException
    {
        Scanner fin = new Scanner(new FileReader("Users.txt"));
        PrintWriter fout = new PrintWriter("Userout.txt");

        while(fin.hasNext())
        {
            String a = fin.next();
            String b = fin.next();
            int c = fin.nextInt();
            int d = fin.nextInt();

            if (c==activeAccount.getAccount())
            {
                d = activeAccount.getBalance();
            }
            fout.println(a + "\t" + b + "\t" + c + "\t" + d);
        }
        
        fout.close();
        fin.close();

    }
    

    public static void display()
    {
        System.out.println("ATM Maximum amount is " + max + " AED");
        System.out.println("ATM Available amount is " + available + " AED");
    }

}
