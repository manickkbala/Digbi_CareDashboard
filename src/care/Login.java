package care;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//import org.testng.annotations.Test;

public class Login {

	@Test
	public static void manickk(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.gecko.driver", "/Users/bala/Desktop/Insurance/mip/mip_libraries/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		//Properties file
		Properties prop=new Properties(); 
		FileInputStream ip= new FileInputStream("./config.properties");
		prop.load(ip);
		
		//Maximizing the window
		driver.manage().window().maximize();
		
		//Passing the URL of the webpage
		driver.get(prop.getProperty("URL"));
				
		//Passing the Username 
		driver.findElement(By.xpath("//input[@id='auth-email']")).sendKeys(prop.getProperty("USERNAME"));

		//Passing the Password 
		driver.findElement(By.xpath("//input[@id='auth-password ']")).sendKeys(prop.getProperty("PASSWORD"));

		//clicking the Login Button
		driver.findElement(By.xpath("//button[@id='login']")).click();

		
		System.out.println(prop.getProperty("URL"));
		System.out.println(prop.getProperty("USERNAME"));
		System.out.println(prop.getProperty("PASSWORD"));
		
		
		//Thread.sleep(3000);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("expectedlurl"));
		
		
		Thread.sleep(9000);
		driver.close();
		}

}
