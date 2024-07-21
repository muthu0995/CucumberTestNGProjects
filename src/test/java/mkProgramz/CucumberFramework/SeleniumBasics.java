package mkProgramz.CucumberFramework;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumBasics {
	
	public static void main(String[] args) throws InterruptedException {
		//Chrome Driver Initialization
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//FireFox Driver Initialization
//		System.setProperty("webdriver.gecko.driver", "C:\\FireFoxDriver\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		/*
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		Thread.sleep(6000);
		Set<String> allWindow = driver.getWindowHandles();
		for(String newWindow:allWindow)
			driver.switchTo().window(newWindow);
		Thread.sleep(6000);
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Thread.sleep(6000);
		driver.switchTo().window(parentWindow);
		
		allWindow = driver.getWindowHandles();
		for(String newWindow:allWindow)
			if(!newWindow.equals(parentWindow)) {
				driver.switchTo().window(newWindow);
				driver.close();
				Thread.sleep(6000);
			}
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		allWindow = driver.getWindowHandles();
		for(String newWindow:allWindow)
			if(!newWindow.equals(parentWindow)) {
				driver.switchTo().window(newWindow);
				driver.close();
				Thread.sleep(6000);
			}
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
	
//		WebDriverWait ew = new WebDriverWait(driver,Duration.ofSeconds(60));
		Thread.sleep(6000);
		allWindow = driver.getWindowHandles();
		for(String newWindow:allWindow) {
				driver.switchTo().window(newWindow);
				System.out.println(driver.getCurrentUrl());
		}
		driver.findElement(By.xpath("//span[text()='Customer Analytics Table']")).click();
		for(String newWindow:allWindow)
			if(!newWindow.equals(parentWindow)) {
				driver.switchTo().window(newWindow);
				driver.close();
				Thread.sleep(6000);
			}
		driver.switchTo().window(parentWindow);

		driver.quit();
		*/
		
		/*
		driver.get("https://leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		WebElement from = driver.findElement(By.id("form:drag_content"));
		WebElement to = driver.findElement(By.id("form:drop_header"));
		Actions action = new Actions(driver);
		action.clickAndHold(from).moveToElement(to).release(to).build().perform();
		
		 from = driver.findElement(By.id("form:conpnl"));
		 WebElement panel = driver.findElement(By.xpath("//div[@id='form:restrictPanel']/div[@class='card']"));
		 action.dragAndDropBy(from, 329, 0).build().perform();
		 */
		

		String fullString = "Muthu Kumar";
		System.out.println(fullString.replace("u", ""));
		System.out.println(fullString.replaceAll("u", ""));
		
		String s = "My\\s aaab\\s is\\s aaab\\s name";
	    String s1 = s.replace("\\", "");
	    System.out.println(s1);
	    String s2 = s.replaceAll("\\", "");
	    System.out.println(s2);
		
	}

}
