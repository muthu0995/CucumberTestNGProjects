package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Driver;

public class SeleniumBasics {

    public static void main(String[] args) {
        System.out.println("Hello Selenium");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Muthu Kumar M\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Muthu Kumar M\\Downloads\\geckodriver-v0.37.1-win64\\geckodriver.exe");

//        WebDriver driver= new FirefoxDriver();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.quit();

    }
}
