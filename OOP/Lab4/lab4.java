package Lab4;
import java.util.*;

public class lab4 {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        int h4, r4;
        System.out.print("Enter Employee rate: ");
        r4 = console.nextInt();
        System.out.print("Enter Employee Worked hours: ");
        h4 = console.nextInt();
        EmployeeInfo emp1 = new EmployeeInfo("111","Ahmad","full",35,40);
        EmployeeInfo emp2 = new EmployeeInfo("222", "Khalid", "part", 30,32);
        EmployeeInfo emp3 = new EmployeeInfo();
        EmployeeInfo emp4 = new EmployeeInfo("444", "Amal", "full");

        emp3.setId("333");
        emp3.setName("Sara");
        emp3.setType("full");
        emp3.setRate(35);
        emp3.setHours(45);

        emp4.setRate(r4);
        emp4.setHours(h4);

        System.out.println("");

        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);
        System.out.println(emp4);

        System.out.println("");

        emp1.calc_Salary();
        emp2.calc_Salary();
        emp3.calc_Salary();
        emp4.calc_Salary();

        emp1.Display();
        emp2.Display();
        emp3.Display();
        emp4.Display();
        console.close();
    }
}


class EmployeeInfo{
    private int rate,hours,salary;
    private String id,name,type;
    private boolean error = false;

    public EmployeeInfo() {}//Default

    public EmployeeInfo (String d, String n, String t, int r, int h){
        id = d;
        name = n;
        type = t;
        hours = h;
        rate = r;
        salary = 0;
        error = false;
    }

    public EmployeeInfo(String d, String n, String t){
        id = d;
        name = n;
        type = t;
    }

    public void setId(String d){
        id = d;
    }
    public String getId(){
        return id;
    }

    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }

    public void setType(String t){
        type = t;
    }
    public String getType(){
        return type;
    }

    public void setRate(int r){
        rate = r;
    }
    public int getRate(){
        return rate;
    }

    public void setHours(int h){
        hours = h;
    }
    public int getHours(){
        return hours;
    }

    public int calc_Salary (){
        if (type.equals("full")){
            if (hours<40){
                error = true;
            }
            salary = 500 + (hours-40)*rate;
        }
        else if (type.equals("part")){
            salary = hours*rate;
        }
        return (salary);
    }

    public String toString(){
        return ("EmployeeInfo [ID="+ id +", name=" + name + ", emp_type=" 
        + type + ", worked_hours=" + hours + ", rate= " + rate + "]" );
    }

    public void Display(){
        System.out.println(id + " " + name + " " + type + " " + hours + " " + rate + " " + salary);
        if (error){
            System.out.println("warning " + name + " has worked less than 40 hours");
        }
    }
}


