import java.util.Scanner;
public class MQ19 {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        int grade;
        System.out.print("Enter a valid grade for CMPE320: ");
        grade = console.nextInt();

        if (grade < 0 || grade > 100) System.out.println("Invalid Grade");
        if (grade>= 0 && grade <= 100){
            if (grade>=60) {
                System.out.println("Pass");
                if (grade >=86) System.out.println("Outstanding!!");
            }
            else{ 
                System.out.println("Failed");
                if (grade>=55) System.out.println("You may Appeal");
                if (grade == 59) System.out.println("Will not fail");
            }
            switch (grade){
                case 69:
                System.out.println("Grade can be corrected to 70");
                break;
                case 79:
                System.out.println("Grade can be corrected to 80");
                break;
                case 89:
                System.out.println("Grade can be corrected to 90");
                break;
            }
        }

        console.close();
    }
}
