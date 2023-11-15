import java.util.*;
import java.lang.*;

public class Main
{
    public static void hanoi(int n, String a, String b, String c) 
    {
	    if (n==1) 
            System.out.println("Move a ring from Peg "+ a +" to Peg " +c);
	    else 
        {
		    hanoi(n-1, a, c, b); 
		    hanoi(1, a, b, c); 
		    hanoi(n-1, b, a, c);    
	    }
    }

    public static void main(String args[])
    {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the number of discs: ");
        int disc = console.nextInt();
        String a = "A", b = "B", c = "C";
        System.out.println();
        long t1 = System.nanoTime();
        hanoi(disc, a, b, c); // 
        long t2 = System.nanoTime();
        double time = (double) (t2 - t1) / 1e9;
        System.out.println("Time: " + time);
    }
}