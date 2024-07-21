package mkProgramz.SeleniumMothods;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandles {

	public static void main(String[] args) throws InterruptedException {
		// Chrome Driver Initialization
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement open = driver.findElement(By.xpath("//span[text()='Open']"));
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(3000);
		open.click();
		Set<String> openedWindowsList = driver.getWindowHandles();
		for(String newWindow:openedWindowsList)
			if(!newWindow.equals(parentWindow)) {
				driver.switchTo().window(newWindow);
				Thread.sleep(3000);
				String PageHeader = driver.findElement(By.xpath("//div[@class='layout-main']/div/div/span")).getText();
				PageHeader = PageHeader.replace("/", "");
				PageHeader = PageHeader.trim();
				System.out.println("Page is Switched to "+PageHeader);
				driver.close();
			}
		driver.switchTo().window(parentWindow);
		
		WebElement openMultiple = driver.findElement(By.xpath("//span[text()='Open Multiple']"));
		Thread.sleep(3000);
		openMultiple.click();
		openedWindowsList = driver.getWindowHandles();
		for(String newWindow:openedWindowsList)
			if(!newWindow.equals(parentWindow)) {
				driver.switchTo().window(newWindow);
				Thread.sleep(3000);
				String PageHeader = driver.getTitle();
				System.out.println("Page is Switched to "+PageHeader);
				driver.close();
			}
		driver.switchTo().window(parentWindow);
		
		WebElement closeWindow = driver.findElement(By.xpath("//span[text()='Close Windows']"));
		Thread.sleep(3000);
		closeWindow.click();
		openedWindowsList = driver.getWindowHandles();
		for(String newWindow:openedWindowsList)
			if(!newWindow.equals(parentWindow)) {
				driver.switchTo().window(newWindow);
				Thread.sleep(3000);
				String PageHeader = driver.getTitle();
				System.out.println("Page is Switched to "+PageHeader);
				driver.close();
			}
		driver.switchTo().window(parentWindow);
		
		WebElement openWithDelay = driver.findElement(By.xpath("//span[text()='Open with delay']"));
		Thread.sleep(3000);
		openWithDelay.click();
		Thread.sleep(3000);
		openedWindowsList = driver.getWindowHandles();
		for(String newWindow:openedWindowsList)
			if(!newWindow.equals(parentWindow)) {
				driver.switchTo().window(newWindow);
				Thread.sleep(3000);
				String PageHeader = driver.getTitle();
				System.out.println("Page is Switched to "+PageHeader);
				driver.close();
			}
		driver.switchTo().window(parentWindow);
		
		driver.quit();

	}

}
