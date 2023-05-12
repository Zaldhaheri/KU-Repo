import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class tempConv extends JFrame{
    JTextField tf1,tf2;
    JButton b1,b2;
    JLabel l1;
    public tempConv(){
        GridLayout g = new GridLayout(3,2);
        setLayout(g);
        l1 = new JLabel("Degree C ",SwingConstants.CENTER);
        tf1 = new JTextField();
        tf2 = new JTextField();
        b1 = new JButton("Convert");
        b2 = new JButton("Exit");

        add(l1);
        add(tf1);
        add(b1);
        add(tf2);
        add(b2);
        ConvHandler ch = new ConvHandler();
        b1.addActionListener(ch);
        EXitHandler eh = new EXitHandler();
        b2.addActionListener(eh);
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        tempConv myframe = new tempConv();
    }

    class EXitHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }

    class ConvHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double c = Double.parseDouble(tf1.getText());
            double f = c*1.8+32;
            tf2.setText(c + "C = " + f + " F");
        }
    }
}