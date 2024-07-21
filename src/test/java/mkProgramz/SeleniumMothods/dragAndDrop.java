package mkProgramz.SeleniumMothods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		// Chrome Driver Initialization
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);

		WebElement fromElement = driver.findElement(By.xpath("//div[@data-widget='widget_form_drag']"));
		WebElement toElement = driver.findElement(By.xpath("//div[@data-widget='widget_form_drop']"));

		Actions action = new Actions(driver);
//		action.clickAndHold(fromElement).moveToElement(toElement).release(toElement).build().perform();
		action.dragAndDrop(fromElement, toElement).build().perform();

		WebElement dragElement = driver.findElement(By.xpath("//div[@data-widget='widget_form_conpnl']"));
		action.dragAndDropBy(dragElement, 317, 0).build().perform();
//		action.clickAndHold(dragElement).moveByOffset(317, 0).build().perform();
		
		driver.quit();

	}

}
