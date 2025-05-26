package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;

public class SearchPage {

    WebDriver driver;
    WebDriverWait wait;

    // Driver constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(4)); // Explicit wait 4 seconds
    }

    // Locators
    By clickSearchMenuButton = By.xpath("//div[@class='iMenu']/a[3]");
    By brandAndModelDropdown = By.xpath("//input[@name='marka']");
    By fourWheelsCheckboxOption = By.xpath("//div[@class='searchForms advancedSearchForms']/item[@class='options']/div[3]/label[1]");
    By mostPopularBrand = By.xpath("//div[@class='a']/span[contains(text(),'VW')]");
    By searchButtonWithinSearch = By.xpath("//a[@class='SEARCH_btn MT6']");

    // Methods
    public void selectFourWheelCheckboxOption() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            List<WebElement> elements = driver.findElements(By.id("eimg88"));
            if (elements.isEmpty()) {
                System.out.println("Element is missing");
                return;
            }

            WebElement checkbox = elements.get(0);

            if (checkbox.isDisplayed() && checkbox.isEnabled()) {
                js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'})", checkbox);
                js.executeScript("arguments[0].style.border='3px solid red'", checkbox);
                wait.until(ExpectedConditions.elementToBeClickable(checkbox));
                js.executeScript("arguments[0].click();", checkbox);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to select four wheel checkbox: " + e.getMessage(), e);
        }

        Thread.sleep(500);
    }

    public void clickSearchMenuButton() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            WebElement searchMenuButton = driver.findElement(clickSearchMenuButton);
            if (searchMenuButton.isDisplayed() && searchMenuButton.isEnabled()) {
                // Mark next button when is visible
                js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'})", searchMenuButton);
                js.executeScript("arguments[0].style.border='3px solid red'", searchMenuButton);
                wait.until(ExpectedConditions.elementToBeClickable(searchMenuButton)).click();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Thread.sleep(500);
    }

    public void clickSearchButtonAfterCriteriaSelection () throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {

            WebElement searchAfterCompleteCriteria = driver.findElement(searchButtonWithinSearch);
            wait.until(ExpectedConditions.visibilityOf(searchAfterCompleteCriteria));
            if (searchAfterCompleteCriteria.isDisplayed() && searchAfterCompleteCriteria.isEnabled()) {
                // Mark search button when is visible (little flacky)
                js.executeScript("arguments[0].scrollIntoView({block: 'center'});", searchAfterCompleteCriteria);
                js.executeScript("window.scrollBy(0, -100);");
                js.executeScript("arguments[0].style.border='3px solid red'", searchAfterCompleteCriteria);
                wait.until(ExpectedConditions.elementToBeClickable(searchAfterCompleteCriteria));
                js.executeScript("arguments[0].click();", searchAfterCompleteCriteria);
            }
        } catch (Exception e) {
            throw new RuntimeException("Cannot click on Search button: "+ e.getMessage(), e);
        }
        Thread.sleep(5000);
    }
    public void selectVWModel () throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            WebElement selectBrandDropdown = driver.findElement(brandAndModelDropdown);
            if (selectBrandDropdown.isDisplayed() && selectBrandDropdown.isEnabled()) {
                // Mark brand dropdown menu when is visible
                js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'})", selectBrandDropdown);
                js.executeScript("arguments[0].style.border='3px solid red'", selectBrandDropdown);
                wait.until(ExpectedConditions.elementToBeClickable(selectBrandDropdown)).click();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Thread.sleep(500);

        try {
            WebElement vwOption = driver.findElement(mostPopularBrand);
            if (vwOption.isDisplayed() && vwOption.isEnabled()) {
                // Mark VW option when is visible
                js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'})", vwOption);
                js.executeScript("arguments[0].style.border='3px solid red'", vwOption);
                wait.until(ExpectedConditions.elementToBeClickable(vwOption)).click();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Thread.sleep(500);
    }
}