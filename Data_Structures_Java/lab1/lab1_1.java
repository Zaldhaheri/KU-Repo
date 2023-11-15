import java.util.*;

public class Driver
{
    public static void main(String args[])
    {
        Point point1, point2, point3, point4, point5, point6;
        Scanner console = new Scanner(System.in);
        int s1, s2;
        point1 = new Point();
        point2 = new Point(1, 2);
        point3 = new Point(3, 4, 5);
        point4 = new Point(6, 7);
        System.out.println("1st " + point1 + "\n2nd" + point2 + "\n3rd" + point3 + "\n4th" + point4);
        System.out.println("What is the size of the point you want to create (2 or 3)?");
        s1 = console.nextInt();
        point5 = new Point();
        if (s1 == 2)
            point5 = new Point(8, 9);
        else if (s1 == 3)
            point5 = new Point(8, 9, 10);
        else
        {
            System.out.println("Error: size can only be 2 or 3");
            System.exit(1);
        }
        System.out.println("5th: " + point5);
        System.out.println("What is the size of the point you want to create (2 or 3)?");
        s2 = console.nextInt();
        point6 = new Point();
        if (s2 == 2)
            point6 = new Point(10, 11);
        else if (s2 == 3)
            point6 = new Point(10, 11, 12);
        else
        {
            System.out.println("Error: size can only be 2 or 3");
            System.exit(1);
        }
        System.out.println("6th: " + point6);
    }
}

class Point
{
    private int size;
    private int [] dataPtr;
    public Point()
    {
        dataPtr = new int[2];
        dataPtr[0] = 0;
        dataPtr[1] = 0;
        size = 2;
    }
    public Point(int x, int y)
    {
        dataPtr = new int[2];
        dataPtr[0] = x;
        dataPtr[1] = y;
        size = 2;
    }
    public Point(int x, int y, int z)
    {
        dataPtr = new int[3];
        dataPtr[0] = x;
        dataPtr[1] = y;
        dataPtr[2] = z;
        size = 3;
    }
    public int getX()
    {
        return (dataPtr[0]);
    }
    public int getY()
    {
        return (dataPtr[1]);
    }
    public int getZ()
    {
        if (size == 3)
            return (dataPtr[2]);
        System.out.println("Size is not 3");
        System.exit(1);
        return (0);
    }
    public String toString()
    {
        if (size == 3)
            return ("Point: x = " + dataPtr[0] + " y = " + dataPtr[1] + " z = " + dataPtr[2]);
        return ("Point: x = " + dataPtr[0] + " y = " + dataPtr[1]);
    }
}