import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen {
    private JFrame frame;
    private JPanel panel1;
    private JPanel panel2;
    private CardLayout cardLayout;
    
    public LoginScreen() {
        frame = new JFrame("Login Screen");
        panel1 = new JPanel();
        panel2 = new JPanel();
        cardLayout = new CardLayout();
        
        // set up panel1
        JLabel label1 = new JLabel("Welcome to the Login Screen!");
        JButton switchButton = new JButton("Switch to Panel 2");
        switchButton.addActionListener(new SwitchButtonHandler());
        panel1.setLayout(new GridLayout(2, 1));
        panel1.add(label1);
        panel1.add(switchButton);
        
        // set up panel2
        JLabel label2 = new JLabel("Hello!");
        panel2.setLayout(new GridLayout(1, 1));
        panel2.add(label2);
        
        // add panels to frame
        frame.setLayout(cardLayout);
        frame.add(panel1, "panel1");
        frame.add(panel2, "panel2");
        
        // set up frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private class SwitchButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(frame.getContentPane(), "panel2");
        }
    }
    
    public static void main(String[] args) {
        new LoginScreen();
    }
}
