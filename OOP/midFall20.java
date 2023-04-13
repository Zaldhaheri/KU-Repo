import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class midFall20{
    public static void main(String[] args)throws FileNotFoundException{

        int a=0,b=0,c=0,d=0;
        int[] three,five,ten,other;
        int num,prod = 1;

        three = new int[50];
        five = new int[50];
        ten = new int[50];
        other = new int[50];

        Scanner fin = new Scanner(new FileReader("numbers.dat"));
        
        for (int i = 0; i<50; i++){
            num = fin.nextInt();
            if (num%3==0){
                three[a] = num;
                a++;
            }
            if(num%5==0){
                five[b] = num;
                b++;
            }
            if(num%10==0){
                ten[c] = num;
                prod *= num;
                c++;
            }
            if(num%3!=0 && num%5!=0 && num%10!=0){
                other[d] = num;
                d++;
            }
        }//end loop
        
        System.out.print("Three: ");
        for (int i = 0; i<=a ; i++){
            System.out.print(three[i] + " ");
        }
        System.out.println("five: ");
        for (int i = 0; i<=b ; i++){
            System.out.print(five[i] + " ");
        }
        System.out.println("ten: ");
        for (int i = 0; i<=c ; i++){
            System.out.print(ten[i] + " ");
        }
        System.out.print("other: ");
        for (int i = 0; i<=d ; i++){
            System.out.print(other[i] + " ");
        }
        System.out.println("The product is: " + prod);

        fin.close();
    }
}

