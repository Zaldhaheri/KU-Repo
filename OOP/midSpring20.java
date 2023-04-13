import java.util.Scanner;

public class midSpring20{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        int box;
        System.out.print("Enter number of boxes: ");
        box = console.nextInt();
        int open = box;
        if (box>=1){
            for (int i = 1; i<=box ;i++){
                if(i%2==0 || i%3==0 || i%4==0 || i%5==0){
                    open--;
                }
                if(i%9==0){
                    open++;
                }
            }
        }
        else System.out.print("Invalid number of boxes");

        System.out.println(open + " number of boxes open");
        console.close();
    }
}