package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.http.ConnectionFailedException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com\r\n");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement oppurtunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		driver.executeScript("arguments[0].click();", oppurtunity);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow']/input[@name='Name']")).sendKeys("Software Automation by RathiSelva");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("3/21/2023");
		driver.findElement(By.xpath("//button[@aria-required='true']")).click(); 
		WebElement none = driver.findElement(By.xpath("//button[@aria-label='Stage, --None--']"));
		driver.executeScript("arguments[0].click();", none);
		WebElement need = driver.findElement(By.xpath("//span[text()='Needs Analysis'][@class='slds-truncate']"));
		driver.executeScript("arguments[0].click();", need);
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		WebElement title = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']"));
		String text = title.getText();
		if(text.contains("RathiSelva")) {
			System.out.println("created well");
			
		}else {
			System.out.println("please do check");
		}
		
		
		
		
		
		
		

		
	}

}
