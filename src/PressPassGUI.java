import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;

public class PressPassGUI extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JTextField user;
	private JTextField pass;
	private JButton submit;
	
	public PressPassGUI() {
		super("PressPass");
		
		user = new JTextField();
		pass = new JPasswordField();
		submit = new JButton("Add");
		submit.addActionListener(this);
		
		JPanel pressPassPanel = new JPanel(new GridLayout(20, 1));
		pressPassPanel.setPreferredSize(new Dimension(400, 400));
		
		pressPassPanel.add(new JLabel(""));
		pressPassPanel.add(new JLabel(""));
		pressPassPanel.add(new JLabel("Enter the required information: ", SwingConstants.CENTER));
		pressPassPanel.add(new JLabel(""));
		pressPassPanel.add(new JLabel(""));
		
		JPanel userPanel = new JPanel(new GridLayout(1, 4));
		userPanel.add(new JLabel(""));
		userPanel.add(new JLabel("Username: "));
		userPanel.add(user);
		userPanel.add(new JLabel(""));
		
		pressPassPanel.add(new JLabel(""));
		pressPassPanel.add(new JLabel(""));
		pressPassPanel.add(userPanel);
		pressPassPanel.add(new JLabel(""));
		pressPassPanel.add(new JLabel(""));
		
		JPanel passPanel = new JPanel(new GridLayout(1, 4));
		passPanel.add(new JLabel(""));
		passPanel.add(new JLabel("Password: "));
		passPanel.add(pass);
		passPanel.add(new JLabel(""));
		
		pressPassPanel.add(new JLabel(""));
		pressPassPanel.add(new JLabel(""));
		pressPassPanel.add(passPanel);
		pressPassPanel.add(new JLabel(""));
		pressPassPanel.add(new JLabel(""));
		
		JPanel submitPanel = new JPanel(new GridLayout(1, 3));
		submitPanel.add(new JLabel(""));
		submitPanel.add(submit);
		submitPanel.add(new JLabel(""));
		pressPassPanel.add(new JLabel(""));
		pressPassPanel.add(new JLabel(""));
		pressPassPanel.add(submitPanel);
		pressPassPanel.add(new JLabel(""));
		pressPassPanel.add(new JLabel(""));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(pressPassPanel);
		pack();
		setVisible(true);
	}
	
	
	public String encrypt(String passed) {
	    String encrypted = "";
	    HashMap converter = new HashMap();
	    char[] chars = passed.toCharArray();
	    int counter = 0;

	    for (int i = 0; i < chars.length; i++) {
	      char temp = chars[i];
	      int translated = converter.getIndex(temp);
	      encrypted = encrypted + translated + "#";
	      converter.convert();
	      counter++;
	    }

	    encrypted = encrypted + counter;
	    return encrypted;
	  }
	
	
	public void actionPerformed(ActionEvent a) {
		Object o = a.getSource();
		
		if (o == submit) {
			
			try{

		        String username = user.getText();
		        String un = encrypt(username);

		        PrintWriter writer = new PrintWriter("user.txt", "UTF-8");
		        writer.println(un);

		        String password = pass.getText();
		        String ep = encrypt(password);
		        
		        writer.println(ep);
		        writer.close();
		      } catch (IOException e) {
		        System.out.println("Catch Exception");
		      }
			dispose();
		}
	}
	
	
}
