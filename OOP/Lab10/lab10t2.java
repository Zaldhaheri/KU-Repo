import java.io.*;
import java.util.*;

//main
public class lab10t2{
    public static void main(String args[]) throws AccountNumException{
        //saving account 1
        SavingAccount s1 = new SavingAccount("1222","Zayed",1000,0.05);
        s1.withdraw(200);
        s1.deposit(500);
        s1.displayBalance();
        s1.createMonthlyStatement();

        //checking account 1
        CheckingAccount c1 = new CheckingAccount("0470","Abdulrahman",2000,4);
        c1.writeCheck("Rashid",500);
        c1.createMonthlyStatement();

        //saving account 2
        SavingAccount s2 = new SavingAccount("1330","Nasser",500,0.04);

        //checking account 2
        CheckingAccount c2 = new CheckingAccount("1300","Zayed",1250,3);

        Bank kuBank = new Bank("KU Bank");
        kuBank.addCustomer(s1);
        kuBank.addCustomer(c1);
        kuBank.addCustomer(s2);
        kuBank.addCustomer(c2);

        kuBank.printSize();

        kuBank.removeCustomer(kuBank.getCustomer(2));
        kuBank.printSize();
        
        CheckingAccount checking = new CheckingAccount("12345678910","omair",123,2);
    }
}

//interface
interface PrintToFile{
    void Print(String t);
}
//superclass
abstract class BankAccount implements PrintToFile {
    //attributes
    protected String accountNumber,ownerName;
    protected double balance;

    //Constructor
    public BankAccount(String a, String o, double b)throws AccountNumException{
        
    	//task 2 exception
    	if (a.length()>10) {
    		throw new AccountNumException();    		
    	}
        
        accountNumber = a;
        ownerName = o;
        balance = b;
    }

    //methods
    public boolean withdraw(double w){
        if (w <= balance){
            balance -= w;
            return true;
        }
        return false;
    }

    public void deposit(double d){
        balance += d;
    }

    public void displayBalance(){
        System.out.println("Your balance is: " + balance);
    }

    //abstract method
    public abstract void createMonthlyStatement();

    public String toString(){
        return "Account Number: " + accountNumber + ", Owner Name: " + ownerName + ", Balance: " + balance;
    }

    //interface method
    public void Print(String str){
        try{
            PrintWriter fout = new PrintWriter(new FileOutputStream(new File("appendt2.txt"),true));  
            fout.println(str);
            fout.close();  
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

//subclass
class CheckingAccount extends BankAccount{
    //attributes
    private int numOfWrittenChecks;
    private final double serviceCharge = 10;
    private final int maxNumOfChecks = 7;
    private final int maxNumOfFreeChecks = 3;

    //constructor
    public CheckingAccount(String a, String o, double b, int n) throws AccountNumException{
        super(a,o,b);
        if (n > maxNumOfChecks && n <= 0) numOfWrittenChecks = 0;
        else numOfWrittenChecks = n;
    }

    //methods
    public double pay(){
        if (numOfWrittenChecks-maxNumOfFreeChecks>0){
            return (numOfWrittenChecks-maxNumOfFreeChecks)*serviceCharge;
        }
        return 0;
    }

    public void writeCheck(String person, double money){
        if (super.withdraw(money)){
            numOfWrittenChecks += 1;
            Print("This is a check for: " + person + " with an amount of " + money + " from account#" + super.accountNumber);
            Print("");
        }
        else{
            Print("Insufficient fund to write a check for " + person);
            Print("");
        }
        
    }

    public String toString(){
        return super.toString() + ", Number of Checks: " + numOfWrittenChecks;
    }

    public void createMonthlyStatement(){
        Print("Dear " + super.ownerName);
        Print("This is the monthly statement of your checking account#" + super.accountNumber);
        Print("You have currently " + super.balance + " AED available in your account");
        Print("The total number of generated checks is " + numOfWrittenChecks + " and a charge of " + pay() + " AED was");
        Print("withdrawn of your account for writing " + pay()/serviceCharge + " extra checks more than your limit");
        Print("For any questions or inquires please make sure to contact us at");
        Print("bank@ku.ac.ae");
        Print("Regards");
        Print("");
    }
}

//subclass
class SavingAccount extends BankAccount{

    //default attribute
    private double interestRate = 0.05;

    //constructor
    public SavingAccount(String a, String o, double b, double i) throws AccountNumException{
        super(a,o,b);
        interestRate = i;
    }

    //methods
    public double interest(){
        return balance*interestRate;
    }

    public double addInterest(){
        super.deposit(interest());
        return super.balance;
    }

    public String toString(){
        return super.toString() + ", Interest Rate: " + interestRate;
    }

    public void createMonthlyStatement(){
        Print("Dear " + super.ownerName);
        Print("This is the monthly statement of your checking account#" + super.accountNumber);
        Print("You were payed an amount of " + interest() + " AED as an interest on your account. So, ");
        Print("your current balance is " + addInterest() + " AED. ");
        Print("For any questions or inquires please make sure to contact us at");
        Print("bank@ku.ac.ae");
        Print("Regards");
        Print("");
    }
}

//Bank class
class Bank{
    //attributes
    private String name;
    private List<BankAccount> customerList;

    //constructor
    public Bank(String n){
        name = n;
        customerList = new Vector<BankAccount>();
    }

    //methods
    public void addCustomer(BankAccount b){
        customerList.add(b);
    }

    public void removeCustomer(BankAccount b){
        customerList.remove(b);
    }

    public int getCustomerListSize(){
        return customerList.size();
    }

    public BankAccount getCustomer(int i){
        return customerList.get(i);
    }

    public String getName(){
        return name;
    }

    public void setName(String n){
        name = n;
    }

    public void printSize(){
        System.out.println("Size of customer list in ku Bank: " + getCustomerListSize());
    }
}

//task 2 exception
class AccountNumException extends Exception{
	public AccountNumException() {
		super("Account number's digits should not exceed 10");
	}
	
}
