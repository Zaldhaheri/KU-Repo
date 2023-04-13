public class lab9 {
    public static void main(String[] args){
        Person[] perArr = new Person[5];
        perArr[0] = new Person("Ahmed","Ali","Male");
        perArr[1] = new PartTimeEmployee("Mohammed","Abdulla","Male",33.0,50.0);
        perArr[2] = new FullTimeEmployee("Sara","Salim","Female",3000.0,33.0);
        perArr[3] = new FullTimeEmployee("Amna","Rashid","Female",3000.0,35.0);
        perArr[4] = new FullTimeEmployee("Basim","Humaid","Male",5000.0,40.0);

        ((FullTimeEmployee) perArr[2]).calcPayment(12);

        for ( Person per: perArr){
            System.out.println(per);
        }
    }
}


class Person{
    protected String firstName, lastName, gender;

    public Person(){
        firstName = "";
        lastName = "";
        gender = "";
    }

    public Person(String f, String l, String g){
        firstName = f;
        lastName = l;
        gender = g;
    }

    public String toString(){
        return ("First Name: " + firstName + ", Last Name: " + lastName + ", Gender: " + gender);
    }

    public void display(){
        System.out.println(this);
    }

    public void setFirst(String f){firstName = f;}
    public void setLast(String l){lastName = l;}
    public void setgender(String g){gender = g;}

    public String getFirst(){return firstName;}
    public String getLast(){return lastName;}
    public String getGender(){return gender;}
    
}

class PartTimeEmployee extends Person{
    private double workedHours,ratePerHour,payment;

    public PartTimeEmployee(){
        super();
        workedHours = 0.0;
        ratePerHour = 0.0;
        payment = 0.0;
    }

    public PartTimeEmployee(String f, String l, String g, double w, double r){
        super(f,l,g);
        workedHours = w;
        ratePerHour = r;
        calcPayment();
    }

    public void calcPayment(){payment = workedHours*ratePerHour;}

    public String toString(){
        return (super.toString() + ", Worked Hours: " + workedHours + ", Rate Per Hour: " + ratePerHour + ", Payment: " + payment);
    }

    public void display(){
        System.out.println(this);
    }

    public void setWorkedHours(double w){workedHours = w;}
    public void setRatePerHour(double r){ratePerHour = r;}

    public double getWorkedHours(){return workedHours;}
    public double getRatePerHour(){return ratePerHour;}
    public double getPayment(){return payment;}

}

class FullTimeEmployee extends Person{
    private double basicSalary,totalHours,payment;

    public FullTimeEmployee(){
        super();
        basicSalary = 0.0;
        totalHours = 0.0;
        payment = 0.0;
    }

    public FullTimeEmployee(String f, String l, String g, double b, double t){
        super(f,l,g);
        basicSalary = b;
        totalHours = t;
        calcPayment();
    }

    public void calcPayment(){
        if (totalHours<30){
            System.out.println(super.firstName + " " + super.lastName + " Has worked for less than 30 hours.");
        }
        payment = (totalHours-30)*10 + basicSalary;
    }

    public void calcPayment(int y){
        if (y>10) {payment = (totalHours-30)*10+basicSalary + 500;}

        else {payment = (totalHours-30)*10 + basicSalary;}
    }

    public String toString(){
        return super.toString() + ", Basic Salary: " + basicSalary + ", Total Hours: " + totalHours + ", Payment: " + payment;
    }

    public void display(){
        System.out.println(this);
    }

}