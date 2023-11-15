import java.util.*;

public class Palindrome{
    public static void main (String[] args){
        Scanner console = new Scanner(System.in);
        
        boolean flag = true;

        do{
            String pal,rev="";
            System.out.println("Enter a string");
            pal = console.next();
            if (pal.equals("exit")){
                flag = false;
            }
            else{
                for (int i=pal.length()-1;i>=0;i--){
                    rev += pal.charAt(i);
                }
                System.out.println("this is rev: " + rev);
                if (pal.equals(rev)){
                    System.out.println("is a palindrome");
                }
                else{
                    System.out.println("is not a palindrome");
                }
            }
        }while(flag);
    }
}