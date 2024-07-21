package mkProgramz.SeleniumMothods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frameHandling {

	public static void main(String[] args) throws InterruptedException {
		// Chrome Driver Initialization
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/frame.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		// IFrame can be handled by Index, Id or name, WebElement
		driver.switchTo().frame(0);
		driver.findElement(By.id("Click")).click();
		driver.switchTo().defaultContent();

		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		System.out.println("Total No.Of Frame in this page:" + iframeList.size());

		driver.switchTo().frame(iframeList.get(1));
		driver.findElement(By.id("Click")).click();
		driver.switchTo().parentFrame();

//Nested Frame
		driver.switchTo().frame(iframeList.get(2));
		driver.switchTo().frame("frame2");
		driver.findElement(By.id("Click")).click();
		driver.switchTo().defaultContent();

		driver.quit();
	}

}
