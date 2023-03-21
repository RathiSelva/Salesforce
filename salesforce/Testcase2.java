package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase2 {
	/*1. Login to https://login.salesforce.com
2. Click on toggle menu button from the left corner
3. Click view All and click Sales from App Launcher
4. Click on Accounts tab 
5. Click on New button
6. Enter 'your name' as account name
7. Select Ownership as Public                                              
8. Click save and verify Account name " */

	public static void main(String[] args) {
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
		WebElement accounts = driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click();", accounts);
		driver.findElement(By.xpath("//a[@class='forceActionLink']/div")).click();
		driver.findElement(By.xpath("//input[@class='slds-input'][@name='Name']")).sendKeys("RathiSelva");
		WebElement none = driver.findElement(By.xpath("//button[@aria-label='Ownership, --None--']"));
        driver.executeScript("arguments[0].click();", none);
        WebElement pub = driver.findElement(By.xpath("//span[text()='Public']"));
        driver.executeScript("arguments[0].click();", pub);
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        WebElement name = driver.findElement(By.xpath("//lightning-formatted-text[@class='custom-truncate']"));
        String text = name.getText();
        if(text.contains("RathiSelva")) {
        	System.out.println("Name was registered well");
        }
         
	}

}
