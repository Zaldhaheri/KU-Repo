import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Lab8Task1 extends JFrame {

    private JLabel txt1,infoP,name1,name2,mail,phone,creditCard,dFrom,dTo,dDate,dReturn,bFees;
    private JButton b1,b2,b3,b4,b5;
    private JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
    public static String to,from;
    static PrintWriter fout;
    public Lab8Task1() {
        GridLayout g  = new GridLayout(18,2);
        setLayout(g);
        setSize(400,500);
        setTitle("Flight Booking System");
        
        txt1 = new JLabel("Welcome to KU Flight Booking");
        infoP = new JLabel("Enter Your Personal Information");
        name1 = new JLabel("First Name: ");
        name2 = new JLabel("Last Name: ");
        mail = new JLabel("Email: ");
        phone = new JLabel("Phone: ");
        creditCard = new JLabel("Credit Card Number: ");
        dFrom = new JLabel("Depart From: ");
        dTo = new JLabel("Depart to: ");
        dDate = new JLabel("Departure Date: ");
        dReturn = new JLabel("Return Date: ");
        bFees = new JLabel("Booking Fees: ");

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();
        tf8.setEditable(false);

        b1 = new JButton("AbuDhabi");
        b2 = new JButton("Dubai");
        b3 = new JButton("London");
        b4 = new JButton("Paris");
        b5 = new JButton("Book");

        add(new JLabel());
        add(txt1);
        add(infoP);
        add(new JLabel());
        add(name1);
        add(tf1);
        add(name2);
        add(tf2);
        add(mail);
        add(tf3);
        add(phone);
        add(tf4);
        add(creditCard);
        add(tf5);
        add(dFrom);
        add(new JLabel());
        add(b1);
        add(b2);
        add(dTo);
        add(new JLabel());
        add(b3);
        add(b4);
        add(new JLabel());
        add(new JLabel());
        add(dDate);
        add(tf6);
        add(dReturn);
        add(tf7);
        add(new JLabel());
        add(new JLabel());
        add(bFees);
        add(tf8);
        add(new JLabel());
        add(new JLabel());
        add(b5);
        setVisible(true);

        tf6.setEditable(false);
        tf7.setEditable(false);

        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);

        b1Handler h1 = new b1Handler();
        b2Handler h2 = new b2Handler();
        b3Handler h3 = new b3Handler();
        b4Handler h4 = new b4Handler();
        b5Handler h5 = new b5Handler();

        b1.addActionListener(h1);
        b2.addActionListener(h2);
        b3.addActionListener(h3);
        b4.addActionListener(h4);
        b5.addActionListener(h5);
        
        textHandler th = new textHandler();

        tf5.addActionListener(th);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }




    public static void main(String[] args)  throws FileNotFoundException{
        Lab8Task1 A = new Lab8Task1();
        fout = new PrintWriter("Receipt.txt");

    }

    class textHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (!( tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty() || tf4.getText().isEmpty() || tf5.getText().isEmpty() )){
                b1.setEnabled(true);
                b2.setEnabled(true);
            }
        }
    }

    class b1Handler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            b1.setEnabled(true);
            b2.setEnabled(false);
            b3.setEnabled(true);
            b4.setEnabled(true);
            from = "AbuDhabi";
        }
    }

    class b2Handler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            b2.setEnabled(true);
            b1.setEnabled(false);
            b3.setEnabled(true);
            b4.setEnabled(true);
            from = "Dubai";
        }
    }

    class b3Handler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            b3.setEnabled(true);
            b4.setEnabled(false);
            if (b1.isEnabled()){
                tf8.setText("7000");
            }
            else{
                tf8.setText("9000");
            }
            tf6.setEditable(true);
            tf7.setEditable(true);
            to = "London";
        }
    }

    class b4Handler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            b4.setEnabled(true);
            b3.setEnabled(false);
            if (b1.isEnabled()){
                tf8.setText("7500");
            }
            else{
                tf8.setText("10000");
            }
            tf6.setEditable(true);
            tf7.setEditable(true);
            to = "Paris";
        }
    }

    class b5Handler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (tf6.getText().isEmpty() || tf7.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"You have left 1 or more empty Text Fields");
                return;
            }
            fout.println("Dear " + tf1.getText() + " " + tf2.getText());
            fout.println("Email: " + tf3.getText());
            fout.println("Phone Number: " + tf4.getText());
            fout.println("Your booking have been confirmed with the following information");
            fout.println("Departure from: " + from + " on " + tf6.getText());
            fout.println("Destination is: " + to);
            fout.println("Return date to your city is : " + tf7.getText());
            fout.println("Ticket fees are " + tf8.getText());
            fout.println("Your credit card #" + tf5.getText() + " was used to pay for this ticket");
            fout.println("Thank you for using our airlines \nWe hope you enjoy our flight");
            fout.println("-------------------------------------------------------------------");
            fout.close();
            System.exit(0);
        }
    }
}