import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton add;
	private JButton pressPass;
	
	public StartGUI() {
		super("PressPass");
		
		add = new JButton("Add user");
		pressPass = new JButton("PressPass");
		add.addActionListener(this);
		pressPass.addActionListener(this);
		
		JPanel startPanel = new JPanel(new GridLayout(15, 1));
		startPanel.setPreferredSize(new Dimension(300, 300));
		
		startPanel.add(new JLabel(""));
		startPanel.add(new JLabel(""));
		startPanel.add(new JLabel("Welcome to PressPass", SwingConstants.CENTER));
		startPanel.add(new JLabel(""));
		startPanel.add(new JLabel(""));
		
		JPanel addPanel = new JPanel(new GridLayout(1, 3));
		addPanel.add(new JLabel(""));
		addPanel.add(add);
		addPanel.add(new JLabel(""));
		startPanel.add(new JLabel(""));
		startPanel.add(new JLabel(""));
		startPanel.add(addPanel);
		startPanel.add(new JLabel(""));
		startPanel.add(new JLabel(""));
		

		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(startPanel);
		pack();
		setVisible(true);
	}


	public void actionPerformed(ActionEvent a) {
		Object o = a.getSource();
		
		if(o == add) {
			dispose();
			new PressPassGUI();
		}
		
	}
}
