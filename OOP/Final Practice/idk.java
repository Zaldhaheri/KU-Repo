import java.util.Scanner;
import java.io.*;
public class idk{
    public static void main(String[] args)throws FileNotFoundException{
        Human[] humans = new Human[4];

        Scanner fin = new Scanner(new FileReader("humans.txt"));
        PrintWriter fout = new PrintWriter("humans.out");

        int counter = 0;
        String name = "";
        int age = 0;
        double pay = 0;
        int[] lmarks = new int[5];
        int[] lhours = new int[5];

        while(fin.hasNextLine()){
            String line = fin.nextLine();
            String[] arrline = line.split(" ");
            if (arrline.length == 3){
                name = arrline[0] +" "+ arrline[1];
                age = Integer.parseInt(arrline[2]);
                humans[counter] = new Human(name,age);
                counter++;
            }
            else if (arrline.length == 10){
                name = arrline[0] +" "+ arrline[1];
                age = Integer.parseInt(arrline[2]);
                for(int i = 0; i<5; i++){
                    lhours[i] = Integer.parseInt(arrline[i+4]);
                }
                pay = Double.parseDouble(arrline[9]);
                humans[counter] = new Employee(name,age,arrline[3],lhours,pay);
                counter++;
            }
            else{
                name = arrline[0] + " " + arrline[1];
                age = Integer.parseInt(arrline[2]);
                for(int i = 0; i<5; i++){
                    lmarks[i] = Integer.parseInt(arrline[i+4]);
                }
                humans[counter] = new Student(name,age,arrline[3],lmarks);
                counter++;
            }
        }

        for(Human human: humans){
            fout.println(human);
        }

        if(humans[0].compareTo(humans[1])>0){
            fout.println(humans[0].getName() + " is older than " + humans[1].getName());
        }
        else{
            fout.println(humans[0].getName() + " is younger than " + humans[1].getName());
        }

        if(humans[0].equals(humans[1])){
            fout.println("the humans are the same");
        }
        else{
            fout.println("The humans are not the same");
        }

        Human human1 = new Human(humans[0]);
        fout.println(human1);
        Human human2;
        for (int i = 0; i<4; i++){
            if (humans[i] instanceof Student) {
                human2 = humans[i];
                fout.println(human2);
            }
        }
        
        fout.close();
        fin.close();
    }
}

class Human implements Comparable<Human>{
    protected String name;
    protected int age;
    
    public Human(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Human(Human c){
        this.name = c.name;
        this.age = c.age;
    }

    public void setName(String name){this.name = name;}
    public String getName(){return this.name;}

    public String toString(){
        return name + " " + age;
    }

    public int compareTo(Human h){
        return this.age - h.age;
    }

    public boolean equals(Human h){
        return this.name.equals(h.name);
    }
}

class Employee extends Human{
    private String type;
    private int[] hours;
    private double pay;

    public Employee(String name, int age, String type, int[] a, double pay){
        super(name,age);
        this.type = type;
        this.hours = a;
        this.pay = pay;
    }

    public String getHours(){
        String x = "";
        for (int i = 0; i<5; i++){
            x+= (hours[i] + " ");
        }
        return x;
    }

    public void setHours(int day, int hour){
        hours[day] = hour; //assuming day is between 0-4
    }

    public int getTotalHours(){
        int x = 0;
        for (int i = 0; i<5; i++){
            x += hours[i];
        }
        return x;
    }

    public double totalPay(){
        double x = getTotalHours()*pay;
        if (getTotalHours() > 40 && super.name.equals("FT")){
            for (int i = 0; i<5; i++){
                if ((hours[i] - 8)>0){
                    x+= (hours[i] - 8);
                }
            }
        }

        return x;
    }

    public String toString(){
        return super.toString() + " " + type + " " + getHours() + " " + getTotalHours() + " " + totalPay();
    }
}

class Student extends Human implements Passable{
    private final double PASSMARK = 59.5;
    private String major;
    private int[] marks;

    public Student(String name, int age, String major, int[] marks){
        super(name,age);
        this.major = major;
        this.marks = marks;
    }

    public String getMarks(){
        String x = "";
        for (int i = 0; i<marks.length; i++){
            x += (marks[i] + " ");
        }
        return x;
    }

    public void setMarks(int[] marks){
        boolean ok = true;
        for (int i = 0; i<marks.length; i++){
            if (marks[i]<0 || marks[i]>100){
                ok = false;
            }
        }

        if (ok){
            this.marks = marks;
        }
    }

    public double average(){
        double total = 0;
        for (int i = 0; i<marks.length; i++){
            total += marks[i];
        }
        return total/5;
    }

    // public boolean hasPassed(){
    //     for (int i = 0; i<marks.length; i++){
    //         if(PASSMARK > marks[i]){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    public String toString(){
        String x;
        if (hasPassed()) x = "Passed";
        else x = "Failed";
        return "Student: " + super.toString() + " " + getMarks() + " " + average() + " " + x;
    }
}

public interface Passable{
    void hasPassed();
}