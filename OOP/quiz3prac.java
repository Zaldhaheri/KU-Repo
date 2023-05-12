import java.util.*;


public class quiz3prac {
    public static void main(String[] args){
        PersonalInfo me = new PersonalInfo("Zayed","AlDhaheri",61222,06,28,03);
        System.out.print(me);
        Vector<Person> pp = new Vector<>();

    }
}

public class Date{
    private int dMonth, dDay, dYear;

    public Date(int m, int d, int y){
        this.dMonth = m;
        this.dDay = d;
        this.dYear = y;
    }

    public Date(){
        this.dMonth = 0;
        this.dDay = 0;
        this.dYear = 0;
    }

    public void setDate(int m, int d, int y){
        dMonth = m;
        dDay = d;
        dYear = y;
    }

    public String toString(){
        return dMonth + "/" + dDay + "/" + dYear + " ";
    }

    public int getMonth(){return dMonth;}
    public int getDay(){return dDay;}
    public int getYear(){return dYear;}
}

public class Person{
    private String first_name,last_name;

    public Person(String fn, String ln){
        this.first_name = fn;
        this.last_name = ln;
    }

    public Person(){
        this.first_name = "";
        this.last_name = "";
    }

    public void setName(String fn, String ln){
        first_name = fn;
        last_name = ln;
    }

    public String toString(){
        return "Name: " + first_name + " " + last_name + " ";
    }
}

public class PersonalInfo{
    private int personID;
    private Person name;
    private Date bDay;

    public PersonalInfo(){
        this.personID = 0;
        name = new Person();
        bDay = new Date();
    }

    public PersonalInfo(String fn, String ln, int id, int m, int d, int y){
        this.personID = id;
        name = new Person(fn,ln);
        bDay = new Date(m,d,y);
    }

    public void setPersonalInfo(String fn, String ln, int id, int m, int d, int y){
        personID = id;
        name.setName(fn,ln);
        bDay.setDate(m,d,y);
    }

    public String toString(){
        return name.toString() + ", ID: " + personID + ", Birthday: " + bDay.toString();
    }

}


// public abstract class ball{
//     protected int x;

//     public void abstract Print();
    
//     public void setX(int a) {x = a;}
//     public ball(){
//         x = 0;
//     }
// }

// public class balling extends ball{
//     public void rint(){
//         System.out.print("BALlsS");
//     }
// }
