// import java.lang.*;
// import java.util.*;

// public class Main
// {
//     public static long Fibonacci(int n)
//     {
//         long fnm2=0, fnm1=1, fn=0; //3
//         if(n<2) // 1
//             return n; // 1
//         else // 1
//         {
// 		    for(int i=2; i<=n; i++) //1 + (n - 1) + (n - 2)
//             {
// 			    fn=fnm1+fnm2; //2*(n - 2)
// 			    fnm2=fnm1; //n - 2
// 			    fnm1=fn; //n - 2
//             }
//         }
//     return fn; //1
//     }


//     public static void main(String args[])
//     {
//         Scanner console = new Scanner (System.in);
//         System.out.print("Enter the fibonacci number: "); 
//         long n = console.nextInt();
//         System.out.println(); 
//         long t1 = System.nanoTime();
//         for (int i = 0; i <= n; i++) //1 + (n + 1) + n
//         {
//             System.out.println("Fibonacci(" + i + ") = " + Fibonacci(i));// (1 + (6n - 3))(n + 1)
//         }
//         long t2 = System.nanoTime();
//         long time = t2 - t1;
//         System.out.println("Time = " + time);
//     }
// }

import java.lang.*;
import java.util.*;

public class Main
{
    public static long Fibonacci(int n) {
	if(n<2) //1
        return n; //1
	else
        return Fibonacci(n-1)+Fibonacci(n-2); //5 + T(n-1) + T(n) 
    }

    public static void main(String args[])
    {
        Scanner console = new Scanner (System.in); //1
        System.out.print("Enter the fibonacci number: "); //1
        long n = console.nextInt(); //1
        System.out.println(); //1
        long t1 = System.nanoTime();
        for (int i = 0; i <= n; i++) //1 + (n + 1) + n
        {
            System.out.println("Fibonacci(" + i + ") = " + Fibonacci(i));// (1 + (5 + T(n - 1) + T(n)))(n + 1)
        }
        long t2 = System.nanoTime();
        long time = t2 - t1;
        System.out.println("Time = " + time);
    }
}