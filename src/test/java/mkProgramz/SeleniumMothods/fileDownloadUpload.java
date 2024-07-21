package mkProgramz.SeleniumMothods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class fileDownloadUpload {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// Chrome Driver Initialization
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");

		// To download in particular folder
		Map<String, Object> perf = new HashMap<String, Object>();
		perf.put("download.default_directory", "C:\\Users\\Muthu Kumar M\\Downloads\\SeleniumDownloadTestingFolder");
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("prefs", perf);
		WebDriver driver = new ChromeDriver(option);

		driver.get("https://leafground.com/file.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);

		WebElement download = driver.findElement(By.xpath("//span[text()='Download']"));
		download.click();
		Thread.sleep(6000);

		File file = new File("C:\\Users\\Muthu Kumar M\\Downloads\\SeleniumDownloadTestingFolder");
		for (File getFile : file.listFiles())
			if (getFile.getName().equals("TestLeaf Logo.png")) {
				System.out.println("Download file is available in folder");
				break;
			}

		WebElement upload = driver.findElement(
				By.xpath("//h5[text()='Basic Upload']//parent::div//span[@class='ui-fileupload-simple ui-widget']"));
		upload.click();
		Thread.sleep(3000);

		StringSelection stringSelector = new StringSelection(
				"C:\\Users\\Muthu Kumar M\\Downloads\\Retirement Plan.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelector, null);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		// "naturalWidth" is used to check brokenImage
		// element.getAttribute("naturalWidth").equals("naturalWidth")

		// get colorOfbutton
		// element.getCssValue("background-color")

	}

}
