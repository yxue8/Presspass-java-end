import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class KeyGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private ImageIcon picture;
	
	public KeyGUI() {
		super("PressPass");
		
		JPanel imagePanel = new JPanel(new GridLayout(1, 1));
		imagePanel.setPreferredSize(new Dimension(200, 200));
		
		picture = new ImageIcon("key.gif");
		JLabel image = new JLabel(picture);
		imagePanel.add(image);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(imagePanel);
		pack();
		setVisible(true);
		
		openweb();
	}
	
	public static String decrypt(String encrypted) {
	    String[] convertString = encrypted.split("#");
	    int index = convertString.length - 1;
	    String sCounter = convertString[index];
	    index--;
	    int counter = Integer.parseInt(sCounter);
	    HashMap decoder = new HashMap();
	    String decrypted = "";

	    while (counter > 1) {
	      decoder.convert();
	      counter--;
	    }

	    while (index >= 0) {
	      int i = Integer.parseInt(convertString[index]);
	      char temp = decoder.getChar(i);
	      decrypted = temp + decrypted;
	      decoder.revert();
	      index--;
	    }
	    return decrypted;
	}

	public static void openweb()
	{
	
		String un = "";
		String dp = "";
		
		try{
		FileReader fileReader =
                new FileReader("user.txt");

        BufferedReader bufferedReader =
                new BufferedReader(fileReader);

        un = decrypt(bufferedReader.readLine());
        dp = decrypt(bufferedReader.readLine());
		}catch (Exception e)
		{
			System.out.println(e);
		}

		System.setProperty("webdriver.edge.driver", "C://selenium//MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://www.facebook.com"); 
        WebElement username = driver.findElement(By.name("email"));
        System.out.println(username);
        username.sendKeys("level1tinker@gmail.com");
        
        WebElement pass = driver.findElement(By.name("pass"));
        pass.sendKeys("tony19970711");
        
        pass.submit();

        }
	
	
}
