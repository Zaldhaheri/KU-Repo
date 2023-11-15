import java.util.Scanner;

public class midSpring21
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        int n = 0;
        int num,sum = 0;
        boolean valid = false;

        while(n<10){
            System.out.println("Enter a number between 20-40 or 60-80");
            num = console.nextInt();
            if ((num >= 20 && num <=40)||(num>=60 && num<=80)){
                valid = true;
                sum = sum + num;
            }
            else {
                while(!valid){
                    System.out.println("Number is invalid, enter a valid number: ");
                    num = console.nextInt();
                    if ((num >= 20 && num <=40)||(num>=60 && num<=80)){
                        valid = true;
                        sum = sum + num;
                    }
                }
            }
            n++;
            valid = false;
        }
        //end while

        System.out.println("The product of the 10 numbers is: " + sum);
    }
}

