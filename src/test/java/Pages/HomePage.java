package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    // Driver constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(4)); // Explicit wait 4 seconds
    }

    // Locators
    By acceptCookiesBtn = By.xpath("//div[@id='cookiescript_accept']");
    By showCookiesDetail = By.xpath("//div[@id='cookiescript_manage']");
    By declineCookieAll = By.xpath("//div[@id='cookiescript_reject']");
    By searchMenuButton = By.xpath("//div[@class='iMenu']/a[3]");


    // Methods
    public void acceptCookies() {
        try {
            if(driver.findElements(acceptCookiesBtn).size() > 0) {
                wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesBtn)).click();
                //System.out.println("Cookie accepted");
            }
        } catch (Exception e) {
            System.out.println("Cookie accept button locator is missing " + e.getMessage());
        }
    }

    public void declineCookies() {
        try {
            if(driver.findElements(showCookiesDetail).size() > 0) {
                wait.until(ExpectedConditions.elementToBeClickable(showCookiesDetail)).click();
                wait.until(ExpectedConditions.elementToBeClickable(declineCookieAll)).click();
                //System.out.println("Cookie declined");
            }
        } catch (Exception e) {
            System.out.println("Cookie decline button locator is missing " + e.getMessage());
        }
    }

    public String waitForHomePageTitle(String expectedTitle) {
        try {
            wait.until(ExpectedConditions.titleIs(expectedTitle));
            return driver.getTitle();
        } catch (Exception e) {
            //System.out.println("Title does not match for given timeframe wait");
            return driver.getTitle(); // Return title even timeframe expire
        }
    }

    public void clickSearchMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(searchMenuButton)).click();
    }

}