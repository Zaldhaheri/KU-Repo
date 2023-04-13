import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class tempConv1 extends JFrame{
    JTextField tf1;
    JTextArea tf2;
    JButton b1,b2,b3;
    JLabel l1;
    static PrintWriter fout;
    public tempConv1(){
        GridLayout g = new GridLayout(3,2);
        setLayout(g);
        l1 = new JLabel("Degree",SwingConstants.CENTER);
        tf1 = new JTextField();
        tf2 = new JTextArea();
        b1 = new JButton("C2F");
        b2 = new JButton("F2C");
        b3 = new JButton("EXIT");

        add(l1);
        add(tf1);
        add(b1);
        add(tf2);
        add(b2);
        add(b3);
        ConvC2F cf = new ConvC2F();
        b1.addActionListener(cf);
        ConvF2C fc = new ConvF2C();
        b2.addActionListener(fc);
        EXitHandler eh = new EXitHandler();
        b3.addActionListener(eh);
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args)throws FileNotFoundException{
        fout= new PrintWriter("Output.txt");
        tempConv1 myframe = new tempConv1();
        
    }

    class EXitHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            fout.print(tf2.getText());
            fout.close();
            System.exit(0);
        }
    }

    class ConvC2F implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double c = Double.parseDouble(tf1.getText());
            double f = c*1.8+32;
            tf2.append(String.format("%.2f C = %.2f F\n",c,f));
        }
    }

    class ConvF2C implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double f = Double.parseDouble(tf1.getText());
            double c = (f-32)/1.8;
            tf2.append(String.format("%.2f F = %.2f C \n",f,c));
        }
    }
}