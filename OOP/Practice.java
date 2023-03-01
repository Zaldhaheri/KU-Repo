import javax.swing.JOptionPane;
import java.io.*;

public class Practice{
    public static void main(String[] args)throws FileNotFoundException{
        String ch[] = {"ASCII.txt","balls.txt","pp.txt"};
        String f = (String) JOptionPane.showInputDialog(null, "Choose now...",
        "The Choice of a Lifetime",JOptionPane.QUESTION_MESSAGE, null, ch,ch[0]);
        PrintWriter outFile = new PrintWriter(f);

        char ascii = 66;
        while (ascii<91){
            for (int i=0; i<5; i++){
                outFile.print(ascii + "\t");
                ascii++;
            }
            outFile.println();
        }
        outFile.close();
    }
}
