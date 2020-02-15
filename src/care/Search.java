package care;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Search extends LogintestNG

	{
	@Test (priority = 3)
	public void searchFullname() throws InterruptedException 
	{
		//getting the search text
		String SearchFullname = driver.findElement(By.xpath("//tr[1]/td[1]/h5/a")).getText();
		System.out.println(SearchFullname);
		Thread.sleep(2000);
		//Search text box
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(SearchFullname);
		System.out.println("*** search keyword inputted is " + SearchFullname );
		Thread.sleep(2000);

		//Search Icon
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("*** Clicked on Search icon ***");
		
		//confirming the search result
		String searchresult = driver.findElement(By.xpath("//tr/td/h5/a")).getText();
		Assert.assertEquals(searchresult, SearchFullname);
		System.out.println("*** The SearchFull name is proper ***");
		Thread.sleep(3000);
	}
	
	@Test (priority = 4)
	public void searchFirstname() throws InterruptedException
	{
		String SearchFullname = driver.findElement(By.xpath("//tr[1]/td[1]/h5/a")).getText();
		System.out.println("*** The full name is " + SearchFullname + " ***");
		String[] SearchInput = SearchFullname.split(" ", 2);
		String SearchFirst = SearchInput[0];
		String Rest = SearchInput[1];
		Thread.sleep(1000);
		
		//Search text box
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(SearchFirst);
		System.out.println("*** search keyword inputted is " + SearchFirst + " ***");
		Thread.sleep(2000);		
		
		//Search Icon
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("*** Clicked on Search icon ***");
		
		//confirming the search result
		String searchresult = driver.findElement(By.xpath("//tr/td/h5/a")).getText();
		Assert.assertEquals(searchresult, SearchFullname);
		
		System.out.println(" *** The Search First name is proper ***");
		Thread.sleep(3000);
	}
	
	@Test (priority = 5)
	public void searchLastname() throws InterruptedException
	{
		String SearchFullname = driver.findElement(By.xpath("//tr[1]/td[1]/h5/a")).getText();
		System.out.println("*** The full name is " + SearchFullname + " ***");
		String[] SearchInput = SearchFullname.split(" ", 2);
		String SearchFirst = SearchInput[0];
		String SearchRest = SearchInput[1];
		Thread.sleep(1000);
		
		//Search text box
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(SearchRest);
		System.out.println("*** search keyword inputted is " + SearchRest + " ***");
		Thread.sleep(2000);	

		//Search Icon
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("*** Clicked on Search icon ***");
		
		//confirming the search result
		String searchresult = driver.findElement(By.xpath("//tr/td/h5/a")).getText();
		Assert.assertEquals(searchresult, SearchFullname);
		
		System.out.println("*** The Search Last name is proper ***");
		Thread.sleep(3000);
		
	}
	
	@Test (priority = 6)
	public void searchUppercase() throws InterruptedException
	{
		String SearchFullname = driver.findElement(By.xpath("//tr[1]/td[1]/h5/a")).getText();
		
		//Search text box with uppercase
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(SearchFullname.toUpperCase());
		Thread.sleep(3000);
		
		//Search Icon
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("*** Clicked on Search icon ***");

		//confirming the search result
		String searchresult = driver.findElement(By.xpath("//tr/td/h5/a")).getText();
		Assert.assertEquals(searchresult, SearchFullname);
		System.out.println("*** The Search Uppercase is proper ***");
		Thread.sleep(3000);
		
	}
	
	
	
	@AfterSuite
	public void terminate() throws InterruptedException
	{
		Thread.sleep(5000);
		//1.End session
		driver.findElement(By.xpath("//i[@class='fas fa-user fa-fw']")).click();
		driver.findElement(By.partialLinkText("Logout")).click();
		Thread.sleep(2000);
		
		//1.A.Cancel button
		String beforecancelclick = driver.getCurrentUrl();
		driver.findElement(By.xpath("//button[.='Cancel']")).click();
		String Aftercancelclick = driver.getCurrentUrl();
		Assert.assertEquals(Aftercancelclick, beforecancelclick);	
		System.out.println("*** Cancel is success ***");
		
		//1.B.Logout button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[@class='fas fa-user fa-fw']")).click();
		driver.findElement(By.partialLinkText("Logout")).click();
		String beforeLogoutclick = driver.getCurrentUrl();
		//System.out.println(beforeLogoutclick);
		driver.findElement(By.xpath("//a[.='Logout']")).click();
		Thread.sleep(2000);
		//SoftAssert softAssert = new SoftAssert();
		//softAssert.assertTrue(beforeLogoutclick.equals(prop.getProperty("Afterlogout")));
		//softAssert.assertEquals(beforeLogoutclick, prop.getProperty("Afterlogout"));	
		System.out.println("*** Logout is success ***");
		//softAssert.assertAll();	
		
		Thread.sleep(5000);
		driver.close();
	}

	}
