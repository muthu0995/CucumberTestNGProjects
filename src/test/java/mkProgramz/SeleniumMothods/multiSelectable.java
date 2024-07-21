package mkProgramz.SeleniumMothods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class multiSelectable {

	public static void main(String[] args) throws InterruptedException {
		// Chrome Driver Initialization
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/list.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		List<WebElement> fromList = driver
				.findElements(By.xpath("//div[@class='ui-picklist-list-wrapper']/ul[@aria-label='From']/li"));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//h5[text()='Pick List']"))).build().perform();
		
		action.keyDown(Keys.CONTROL).click(fromList.get(0)).click(fromList.get(1)).click(fromList.get(2)).build()
				.perform();

		driver.quit();
	}

}
