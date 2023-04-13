import java.util.*;
import java.io.*;


public class CarDriver
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner fin = new Scanner(new FileReader("car.txt"));
        int sum = Car.CalculateDistance();
        System.out.println("distance travelled is: " + sum);

        String a = fin.next();
        String b = fin.next();
        float c = fin.nextFloat();
        int d = fin.nextInt();

        Car c1 = new Car (a,b,c,d);
        Car c2 = new Car (c1);
        Car c3 = new Car ();

        c3.setType("Ford");
        c3.setModel("Focus");
        c3.setMpg(45);
        c3.setSpeed(120);

        c1.increaseSpeed(10);
        c3.increaseSpeed(5);

        c1.toString();
        c2.toString();
        c3.toString();

        if (c1.equals(c2)) System.out.println("Cars are the same.");
        else System.out.println("Cars are not the same.");
    }
}

class Car
{
    private String type,model;
    private float mpg;
    private int speed;
    private static final int SPEEDLIMIT = 120;
    
    public Car(){}

    public Car(String t, String m, float mp, int s)
    {
        type = t;
        model = m;
        mpg = mp;
        speed = s;
    }

    public Car(Car c)
    {
        type = c.type;
        model = c.model;
        mpg = c.mpg;
        speed = c.speed;
    }

    public void setType(String t){type = t;}
    public void setModel(String m){model = m;}
    public void setMpg(float mp){mpg = mp;}
    public void setSpeed(int s){speed = s;}

    public String getModel(){return model;}
    public int getSpeed(){return speed;}

    public int compareTo(Car c)
    {
        return speed-c.speed;
    }

    public String toString(){return type + " " + model + " " + mpg + " " + speed; }

    public boolean equals(Car c)
    {
        return (model.equals(c.model) && type.equals(c.type));
    }

    public static int CalculateDistance()
    {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter Distance Travelled");
        int sum = 0;
        while(console.hasNext())
        {
            sum += console.nextInt();
        }
        console.close();
        return sum;
    }

    public void increaseSpeed(int s)
    {
        if ((speed + s)<=SPEEDLIMIT)
        {
            speed+=s;
        }
        else
        {
            System.out.println("Speed Increment not allowed for car " + type);
        }
    }


}