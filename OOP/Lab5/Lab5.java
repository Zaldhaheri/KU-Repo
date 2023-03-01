package Lab5;

public class Lab5 {
    public static void main(String[] args)
    {
        ClientAccount c1 = new ClientAccount();
        ClientAccount c2 = new ClientAccount("Zayed Aldhaheri",61222,2000);

        ATM.setAvailable(4000);
        ATM.setMax(5000);

        ATM.display();

        System.out.println();

        System.out.println(c1);
        System.out.println(c2);

        System.out.println();

        c1.setName("John Smith");
        c1.setAccount(1111);
        c1.setBalance(2500);

        System.out.println(c1);
        System.out.println(c2);
        
        System.out.println();

        c2.withdraw(3000);
        c1.deposit(500);
        c2.deposit(2000);

        System.out.println();

        System.out.println(c1);
        System.out.println(c2);
        ATM.display();

        System.out.println();

        c1.withdraw(2000);
        System.out.println(c1);
        ATM.display();


        ClientAccount c3 = new ClientAccount("Zayed Aldhaheri",61333,2000);

        System.out.println();

        if (c3.equals(c2)){
            System.out.print("The two accounts are the same");
        }
        else
        {
            System.out.print("The two accounts are not the same");
        }
    }
}

class ClientAccount
{
    private String name;
    private int account,balance;
    public ClientAccount()
    {
        name = "Unknown";
        account = 0;
        balance = 0;
    }

    public ClientAccount(String n, int a, int b)
    {
        name = n;
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
        if (ATM.getMax() >= dep + ATM.getAvailable())
        {
            balance += dep;
            ATM.setAvailable(ATM.getAvailable() + dep);
            System.out.println(name + "has deposited " + dep + " AED");
        }
        else
        {
            System.out.println("Dear " + name + " you cant deposit to this account, ATM is full");
        }
    }
    
    public void withdraw(double with)
    {
        if (ATM.getAvailable() >= with && balance>= with)
        {
            balance -= with;
            ATM.setAvailable(ATM.getAvailable() - with);
            System.out.println(name + "has withdrawn " + with + " AED");
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
}

class ATM
{
    private static double available,max;

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

    public static void display()
    {
        System.out.println("ATM Maximum amount is " + max + " AED");
        System.out.println("ATM Available amount is " + available + " AED");
    }
}