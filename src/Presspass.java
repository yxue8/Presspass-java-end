//Yuliang Xue 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.By;
import java.io.*;
import java.io.IOException;
import java.util.*;
import java.io.PrintWriter;

public class Presspass {
	public static void main(String args[]) {
		new StartGUI();

		new ImageGUI();
	}
	
	public static void input()
	  {
	      try{
	        System.out.println("Please Enter Your Username");

	        Scanner input = new Scanner(System.in);

	        String username = input.nextLine();
	        String un = encrypt(username);

	        PrintWriter writer = new PrintWriter("user.txt", "UTF-8");
	        writer.println(un);

	        System.out.println("Please Enter Your Password");

	        String password = input.nextLine();
	        String ep = encrypt(password);
	        
	        writer.println(ep);
	        writer.close();
	      } catch (IOException e) {
	        System.out.println("Catch Exception");
	      }
	  }


	  public static void run() {
	    boolean ongoing = true;
	    while(ongoing)
	    {
	      Scanner input = new Scanner(System.in);
	      String command = input.nextLine();
	      if(command.equals("inputuser"))
	      {
	        input();
	      }

	      else if(command.equals("run"))
	      {
	    	  openweb();
	      }

	      else
	      {
	        System.out.println("Invalid Command");
	      }
	    }
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
        
        if (username.getTagName().equalsIgnoreCase("input") 
                && username.getAttribute("type").equalsIgnoreCase("text")) {
            System.out.println("its a textbox");
        }
	}
	
	//Derrick Hamilton :D (Encrpt) 3/3/2017
	public static String encrypt(String passed) {
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

	
	//Derrick Hamilton :D (Decrpt) 3/3/2017
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
}
