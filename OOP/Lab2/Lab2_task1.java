import javax.swing.JOptionPane;

public class Lab2_task1 {

	public static void main(String[] args) {
		String id = JOptionPane.showInputDialog("Enter ID: "); 
		System.out.println(id);
		
		String pass = JOptionPane.showInputDialog("Enter Password: ");
		System.out.println(pass);
		
		if (id.equals("1111") && pass.equals("student1234")) {
			JOptionPane.showMessageDialog(null, "Access Granted"); 
		}
		else {
			JOptionPane.showMessageDialog(null, "Access Denied"); 
		}
		
	}

}
