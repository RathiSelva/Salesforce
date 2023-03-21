package salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase3 {
	/* Launch the app
2) Click Login
3) Login with the credentials
4) Click on Global Actions SVG icon (can see as + icon at right corner)
5) Click New Task 
6) Enter subject as ""Bootcamp ""                                               
7) Select status as 'Waiting on someone else'
9) Save and verify the 'Task created' message" */


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
		driver.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[text()='Global Actions']")));
		driver.findElement(By.xpath("//a[@title='New Task']")).click();
		driver.findElement(By.xpath("(//input[@role='combobox'] [@type='text'])[2]")).sendKeys("Boot Camp");
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@class='uiPopupTrigger']//a[@class='select']")));
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@title='Waiting on someone else']")));
        driver.findElement(By.xpath("//span[text()='Save']")).click();
	}

}
