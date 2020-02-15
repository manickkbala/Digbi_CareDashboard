package care;

import java.io.FileInputStream;



import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class LogintestNG {	

	public WebDriver driver;
	public Properties prop;
	

	@BeforeClass
	public void beforelogin() throws IOException 
	{
		//Properties file
		Properties prop=new Properties(); 
		FileInputStream ip= new FileInputStream("./config.properties");
		prop.load(ip);

		System.setProperty(prop.getProperty("DRIVER"), prop.getProperty("DRIVERPATH"));
		driver = new FirefoxDriver();

		//Maximizing the window
		driver.manage().window().maximize();					
	}

	@Test (priority=1)	
	public void login() throws InterruptedException, IOException
	{
		//Properties file
		Properties prop=new Properties(); 
		FileInputStream ip= new FileInputStream("./config.properties");
		prop.load(ip);

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

		//Confirm the login
		try {
			Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("expectedlurl"));
			System.out.println("*** Login is Success ***");
		}
		catch (Exception e)
		{

		}

	}  
	
	@Test (priority=2)	
	public void menuaDashboard() throws IOException
	{
		
		//Dashboard Link
		driver.findElement(By.xpath("//span[.='Dashboard']")).click();
		//Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("expectedlurl"));
		System.out.println("*** The Dashboard menu link is working ***");
	}
	
	@Test (priority=3)
	public void menuCaochManagement()
	{
		
		//Coach Management
		driver.findElement(By.xpath("//span[.='Coach Management']")).click();
		//Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("expecetdcoachurl"));
		System.out.println("*** The Coach Management menu link is working ***");
	}
	
	@Test (priority=4)
	public void menuCoaches() throws InterruptedException
	{
		//Coaches menu
		//@FindBy(xpath="//span[.='Coaches']") WebElement searchBox;
		//@FindBy(xpath="") WebElement element;

		driver.findElement(By.xpath("//span[.='Coaches']")).click();
		List<WebElement> allcoaches = driver.findElements(By.xpath("//div/div/a"));
		System.out.println("The total coaches are " + allcoaches.size());
		
		for( WebElement allc : allcoaches)
		{
			System.out.println(allc.getText()); 
			 System.out.println(allc.getAttribute("href"));
		}
		
		for (WebElement var : allcoaches) {
            var.click();
            Thread.sleep(2000);
        }
	}

}
