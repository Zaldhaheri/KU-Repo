import java.util.*;
import java.lang.*;

public class Main
{
    public static void main(String args[])
    {
        long t1 = System.nanoTime();
        long r = 0; //1
        long n = 1000000; //1
        for (int i = 1; i <= n; i++) // 1 + (n + 1) + n
            r += i; // 2(n + 1)
        float avg = (float) r / n; //1
        long t2 = System.nanoTime();
        long time = t2 - t1;
        System.out.println("Sum: " + r);
        System.out.println("Avg: " + avg);
        System.out.println("Time : " + time);
    }
}

// import java.util.*;
// import java.lang.*;

// public class Main
// {
//     public static void main(String args[])
//     {
//         long t1 = System.nanoTime();
//         long r = 0; //1
//         long n = 1000000; //1
//         r = (n * (n + 1)) / 2; //1
//         float avg = (float) r / n; //1
//         long t2 = System.nanoTime();
//         long time = t2 - t1;
//         System.out.println("Sum: " + r); 
//         System.out.println("Avg: " + avg); 
//         System.out.println("Time : " + time);
//     }
// }
