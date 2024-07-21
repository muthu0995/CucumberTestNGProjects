package mkProgramz.SeleniumMothods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingLinks {

	public static void main(String[] args) throws InterruptedException {
		// Chrome Driver Initialization
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/link.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		WebElement dashboard = driver.findElement(By.linkText("Go to Dashboard"));
		dashboard.click();
		Thread.sleep(3000);
		String PageHeader = driver.findElement(By.xpath("//div[@class='layout-main']/div/div/span")).getText();
		PageHeader = PageHeader.replace("/", "");
		PageHeader = PageHeader.trim();
		if(PageHeader.equals("Dashboard")) {
			System.out.println("Page is Switched to "+PageHeader);
		}else
			System.out.println("Page is not navigated to Dashboard");
		driver.navigate().back();
		Thread.sleep(1000);
		
		WebElement urlWithoutClick = driver.findElement(By.linkText("Find the URL without clicking me."));
		System.out.println(urlWithoutClick.getAttribute("href"));
		
		WebElement broken = driver.findElement(By.linkText("Broken?"));
		broken.click();
		if(driver.getTitle().contains("404"))
			System.out.println("Page is broken");
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(1000);
		
//		dashboard.click(); // If I use previous element after refresh or navigation it will throw StaleElementReference Exception
		
		dashboard = driver.findElement(By.xpath("//h5[text()='Duplicate Link']/parent::div//a[text()='Go to Dashboard']"));
		dashboard.click();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		
		List<WebElement> list = driver.findElements(By.xpath("//a[contains(@href,'html')]"));
		System.out.println(list.size());
		
		list = driver.findElements(By.xpath("//div[@class='layout-main-content']//a[contains(@href,'html')]"));
		System.out.println(list.size());

	}

}
