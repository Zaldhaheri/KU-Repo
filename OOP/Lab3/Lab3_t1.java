import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.io.FileNotFoundException;


public class Lab3_t1 {
	
	public static void main(String[] args) throws FileNotFoundException{
		//open files for input and output
		Scanner inFile = new Scanner(new FileReader("lab3.txt"));
		PrintWriter outFile = new PrintWriter ("Students.txt");
		PrintWriter outFile1 = new PrintWriter ("StudentLeftHours.txt");
		PrintWriter outFile2 = new PrintWriter ("maleStudent.txt");
		PrintWriter outFile3 = new PrintWriter ("search.txt");
		//variables
		String id,name,gender,program;
		int finished_credit_hours,credits_to_graduate;
		//asks user to search program
		String ch[] = {"Graduate", "Undergraduate" };
		String input = (String) JOptionPane.showInputDialog(null,"select a student program","Search Box",JOptionPane.QUESTION_MESSAGE,null,ch,ch[0]);
		
		//main code
		while(inFile.hasNext()) {
			//take input from file
			id = inFile.next();
			name = inFile.next();
			gender = inFile.next();
			program = inFile.next();
			finished_credit_hours = inFile.nextInt();
			//outputs data to students.txt file
			outFile.println(id + " " + name + " " + gender + " " + program + " " + finished_credit_hours);
			//calculates how many hours left to graduate
			if (program.equals("undergrad")) {
				credits_to_graduate = 132 - finished_credit_hours;
			}
			else {
				credits_to_graduate = 36 - finished_credit_hours;
			}
			//outputs data to StudentLeftHours.txt file
			outFile1.println(id + " " + name + " " + gender + " " + program + " " + finished_credit_hours + " " + credits_to_graduate);
			
			
			//if male outputs data to maleStudent.txt file
			if (gender.equals("male")) {
				outFile2.println(id + " " + name + " " + gender + " " + program + " " + finished_credit_hours + " " + credits_to_graduate);
			}
			//if grad outputs to search.txt file
			if (input.equals("Graduate") && program.equals("grad")) {
				outFile3.println(id + " " + name + " " + gender + " " + program + " " + finished_credit_hours + " " + credits_to_graduate);
			}
			//if undergrad outputs to search.txt file
			else if (input.equals("Undergraduate") && program.equals("undergrad")) {
				outFile3.println(id + " " + name + " " + gender + " " + program + " " + finished_credit_hours + " " + credits_to_graduate);
			}
			
		}
		
		
		
		
		//close all files
		inFile.close();
		outFile.close();
		outFile1.close();
		outFile2.close();
		outFile3.close();
	}

}
