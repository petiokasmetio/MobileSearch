package Tests;

import Pages.HomePage;
import Utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {

    ReadConfig config = new ReadConfig();
    public String baseURL = config.getApplicationURL();
    public String cookiesAction = config.getCookiesAction();
    public WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();

        // Setup for headless mode
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless"); // For older versions
//        options.addArguments("--headless=new"); // For latest Chrome versions
//        options.addArguments("--disable-gpu");
//        options.addArguments("--window-size=1920,1080"); // important for layout and scroll
//        options.addArguments("--remote-allow-origins=*"); // just in case
//
//        driver = new ChromeDriver(options); //headless
//        driver.get(baseURL); //headless

        driver = new ChromeDriver(); //normal view
        driver.get(baseURL); //normal view
        driver.manage().window().maximize(); //normal view

        HomePage homePage = new HomePage(driver);

        // Accept cookie
        if (cookiesAction.equalsIgnoreCase("accept")) {
            homePage.acceptCookies();
        } else if (cookiesAction.equalsIgnoreCase("reject")) {
            homePage.declineCookies();
        } else {
            System.out.println("Invalid value property for cookieAction " + cookiesAction);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}