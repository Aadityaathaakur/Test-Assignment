package testLink;

import java.util.List;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {
	static WebDriver driver;
	static int invalidImageCount;
	public static void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "/home/qainfotech/Desktop/chromedriver");
		 driver = (WebDriver) new ChromeDriver();
		driver.get("http://10.0.31.161:9292/");
		driver.manage().window().maximize();
	 	
	}
	
	public static void basic_auth() throws InterruptedException{
		driver.findElement(By.xpath("//*[@href='/basic_auth']")).click();
		
		
		Alert alert = driver.switchTo().alert() ;
		//alert.SetAuthenticationCredentials("admin","admin");
		driver.switchTo().defaultContent() ; 
		
		
		
		
		/*Set <String>handles = driver.getWindowHandles();
		String firstWinHandle = driver.getWindowHandle();
		handles.remove(firstWinHandle);
		String winHandle=handles.iterator().next();
		if (winHandle!=firstWinHandle){
		     String secondWinHandle = winHandle;

		driver.switchTo().window(secondWinHandle);  
		Thread.sleep(2000);*/
	
		
	
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
	
	
	
	
	
	
	public static void verifyimageActive(WebElement imgElement) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = (HttpResponse) client.execute(request);
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			if (((org.apache.http.HttpResponse) response).getStatusLine().getStatusCode() != 200)
				{
				invalidImageCount++;
				
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		
	}

