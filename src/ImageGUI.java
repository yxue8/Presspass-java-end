import javax.swing.*;

import java.awt.*;
import java.io.*;
import java.net.*;

public class ImageGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private ImageIcon picture;
	
	public ImageGUI() {
		super("PressPass");
		
		JPanel imagePanel = new JPanel(new GridLayout(1, 1));
		imagePanel.setPreferredSize(new Dimension(200, 200));
		
		picture = new ImageIcon("lock.gif");
		JLabel image = new JLabel(picture);
		imagePanel.add(image);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(imagePanel);
		pack();
		setVisible(true);
		
		boolean ongoing = true;
	      try{
	        ServerSocket serverSock = new ServerSocket(7272);
	      while(ongoing)
	      {

	      Socket clientSock = serverSock.accept();

	      BufferedReader br = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
	      String check = br.readLine();
	      if(check.equals("True"))
	      {
	    	  br.close();
		      clientSock.close();
		      serverSock.close();
	    	  dispose();
	    	  new KeyGUI();
	    	  
		      
	      }

	      br.close();
	      clientSock.close();
	      }

	      serverSock.close();

	    } catch(Exception e) {
	  e.printStackTrace();
	  }
		
		
	}

}
