package testLink;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class ActionClass {
	static WebDriver driver;
	static int invalidImageCount;
	static WebDriverWait wait;
	
	public static void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "/home/qainfotech/Desktop/chromedriver");
		 driver = (WebDriver) new ChromeDriver();
		driver.get("http://10.0.31.161:9292/");
		 wait = new WebDriverWait(driver,20); 
		driver.manage().window().maximize();
	 	
	}
	
	public static void basic_auth() throws InterruptedException{
		//driver.findElement(By.xpath("//*[@href='/basic_auth']")).click();
		
		String admin="admin";
		String URL = "http://" + admin + ":" + admin + "@" + "10.0.31.161:9292/basic_auth";
		driver.navigate().to(URL);

	
		
	
}

	public static void Broken_Images() {
		driver.get("http://10.0.31.161:9292/");
		driver.findElement(By.xpath("//*[@href='/broken_images']")).click();
		try {
			invalidImageCount = 0;
			List<WebElement> imagesList = driver.findElements(By.tagName("img"));
			
			for (WebElement imgElement : imagesList) {
				if (imgElement != null) {
					verifyimageActive(imgElement);
				}
			}
			System.out.println("Total no. of invalid images are "	+ invalidImageCount);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	
	public static void Exit_Intent() {
		driver.findElement(By.xpath("//*[@alt='go to home']")).click();
		driver.findElement(By.xpath("//*[@href='/exit_intent']")).click();

		
	
	}
	
	public static void Sortable_Data_Tables() {
		driver.findElement(By.xpath("//*[@alt='go to home']")).click();
		driver.findElement(By.xpath("//*[@href='/tables']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Due')]")).click();
		
		
	
	}
	
	public static boolean verify_login_page() {
		driver.findElement(By.xpath("//*[@alt='go to home']")).click();
		driver.findElement(By.linkText("Form Authentication")).click();
		return driver.findElement(By.cssSelector("div.example>h2")).getText().equals("Login Page");
	}
	
	public static String verify_invalid_credentiails() {
		driver.findElement(By.xpath("//*[@alt='go to home']")).click();
		driver.findElement(By.xpath("//*[@href='/login']")).click();
		driver.findElement(By.id("username")).sendKeys("skdjf");
		driver.findElement(By.id("password")).sendKeys("skdjf");
		driver.findElement(By.cssSelector("button.radius")).click();

		 driver.findElement(By.xpath("//*[contains(text(),'Your username is invalid!')]"));
		return "Your username is invalid!";
        
		
	}
	
	public static String verify_valid_credentiails() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@alt='go to home']")));
		driver.findElement(By.xpath("//*[@alt='go to home']")).click();
		driver.findElement(By.xpath("//*[@href='/login']")).click();
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("button.radius")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@href='/logout']")).click();
		 
		String st= driver.findElement(By.xpath("//*[@id='flash']")).getText();
		
		st= st.replaceAll("\\s+","")  ;
		System.out.println(st);
		 return st;
	}
	
	
	
	
	
	
	public static void verifyimageActive(WebElement imgElement) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = (HttpResponse) client.execute(request);
			List<String> source= new ArrayList<String>();
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			if (((org.apache.http.HttpResponse) response).getStatusLine().getStatusCode() != 200)
				{
				invalidImageCount++;
				
				//source.add();
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int test_For_3Images_Displayed()
	{driver.findElement(By.xpath("//*[@alt='go to home']")).click();
	driver.findElement(By.xpath("//*[@href='/hovers']")).click();
		List <WebElement> element = driver.findElements(By.className("figure"));
	
		return element.size();
		
		
	}
	public static WebElement Hover_mouse_over()
	{

		WebElement uname;
		String viewP;
	    WebElement element = driver.findElement(By.xpath("//*[@alt='User Avatar']"));
	 
	        Actions action = new Actions(driver);
	 
	        action.moveToElement(element).perform();
	 
	        WebElement subElement = driver.findElement(By.xpath("//*[@class='figcaption']"));
	 
	        action.moveToElement(subElement);
	 
	        action.click();
	 
	        action.perform();
	        uname= driver.findElement(By.xpath("//*[contains(text(),'name: user1')]"));
	        viewP= driver.findElement(By.xpath("//*[@href='/users/1']")).getText();
	        System.out.println(uname+" $ "+viewP);
	        
	        return uname;
	       //return (uname+" "+viewP);
		
	}
	public static WebElement WYSIWYG_Editor_Visible() throws InterruptedException
	   { driver.findElement(By.xpath("//*[@alt='go to home']")).click();
	   driver.findElement(By.xpath("//*[@href='/tinymce']")).click();
	   driver.switchTo().frame("mce_0_ifr");
		return driver.findElement(By.xpath("//*[@id='tinymce']/p"));
	   
	   }
	   public static String WYSIWYG_Editor() throws InterruptedException
	   {
		   //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@alt='go to home']")));
		   driver.navigate().back();
		   driver.findElement(By.xpath("//*[@alt='go to home']")).click();
		   driver.findElement(By.xpath("//*[@href='/tinymce']")).click();
		   driver.switchTo().frame("mce_0_ifr");
		   
		   driver.findElement(By.xpath("//*[@id='tinymce']/p")).clear();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("QA InfoTech");
		   Thread.sleep(2000);
		   WebElement toClear = driver.findElement(By.xpath("//*[@id='tinymce']"));
		   toClear.sendKeys(Keys.CONTROL + "a");
		   
		   driver.switchTo().parentFrame();
		   driver.findElement(By.xpath("//*[@class='mce-ico mce-i-bold']")).click();
		   
		   return driver.findElement(By.xpath("//*[@class='mce-path-item mce-last']")).getText();
	   }
	   
	   public static int Status_Codes() throws InterruptedException
	   {int statusCode = 0;
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@alt='go to home']")));
		   driver.findElement(By.xpath("//*[@alt='go to home']")).click();
		   driver.findElement(By.xpath("//*[@href='/status_codes']")).click();
		   
		WebElement url = driver.findElement(By.xpath("//*[@href='status_codes/404']"));
		
		/* String st= driver.findElement(By.xpath("//*[@class='example']/p")).getText();
		st= st.replaceAll("\\s+","")  ;
		*/
		/*
		if(driver.getPageSource().contains("404"))
		{
			System.out.println("404");
		}*/
		
	/*	String href =href = url.getAttribute("href");
		
		 statusCode = RestAssured.get(href).statusCode();

        if(statusCode==404) {
            System.out.println(href + " gave a response code of " + statusCode);
            
        }*/
		
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(url.getAttribute("href"));
			HttpResponse response = (HttpResponse) client.execute(request);
			
			statusCode=((org.apache.http.HttpResponse) response).getStatusLine().getStatusCode();
			if (statusCode == 404)
				{
				
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	   return statusCode;
	   }
	}

