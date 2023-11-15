import java.util.Scanner;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class midfall19 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner fin = new Scanner(new FileReader("dates.txt"));
        PrintWriter fout = new PrintWriter("output.txt");

        int sukaryNum = 0,khalasNum = 0,madjoolNum = 0,total = 0;
        while(fin.hasNext()){
            String name = fin.next();
            int num = fin.nextInt();
            if (name.equals("Sukary")){
                sukaryNum += num;
            }
            else if(name.equals("Khalas")){
                khalasNum += num;
            }
            else if(name.equals("Madjool")){
                madjoolNum += num;
            }
        }  
        total = sukaryNum + khalasNum + madjoolNum;
        fout.println("There are " + sukaryNum + " packs of Sukary dates.");
        fout.println("There are " + khalasNum + " packs of Khalas dates.");
        fout.println("There are " + madjoolNum + " packs of Madjool dates.");
        fout.println("There is a total of " + total + " packs of dates in the shop");

        fin.close();
        fout.close();
    }

    
}
