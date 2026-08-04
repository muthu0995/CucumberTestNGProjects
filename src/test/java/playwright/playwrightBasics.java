package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightBasics {

    public static void main(String[] args){
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp =  new BrowserType.LaunchOptions();
        lp.setChannel("chrome");
        lp.setHeadless(false);
//        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Browser browser = playwright.firefox().launch(lp);
        Page page = browser.newPage();
        page.navigate("https://www.amazon.com");

        System.out.println(page.title());
        System.out.println(page.url());
        browser.close();
        playwright.close();
    }
}
