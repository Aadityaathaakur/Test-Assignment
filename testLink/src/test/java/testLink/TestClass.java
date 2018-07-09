package testLink;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClass {

	@BeforeClass
	public void launch()
	{
		ActionClass.launchBrowser();
	}
	@Test
	public void test001_basic_auth_test() throws InterruptedException{
		//ActionClass.basic_auth();
	}
	
	@Test
	public void test002_Check_for_Broken_Image() throws InterruptedException{
		ActionClass.Broken_Images();
	}
	
	@Test
	public void test003_Exit_Intent() throws InterruptedException{
		ActionClass.Exit_Intent();
	}
	
	@Test
	public  void test004_Sortable_Data_Tables() {
		ActionClass.Sortable_Data_Tables();
		
	}
	 @Test
	   public void test005_authenticate(){
		
		   Assert.assertTrue(ActionClass.verify_login_page());
	   }
	   
	   @Test
	   public void test006_authenticate_Invalid(){
		 
		   String element= ActionClass.verify_invalid_credentiails();
		   Assert.assertEquals(element, "Your username is invalid!");
	   }
	   
	   @Test
	   public void test007_authenticate_valid() throws InterruptedException{
		 
		   String element= ActionClass.verify_valid_credentiails();
		   System.out.println(element);
		   Assert.assertEquals(element, "You logged out of the secure area!"
		   		+ "×");
	   }
	
	
}
