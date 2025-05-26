package Pages;

import Utilities.FileOutputUtil;
import org.openqa.selenium.*;
import java.io.IOException;
import java.util.List;

public class SearchResultsPage {
    //Driver and js cannot be accessed outside this class due to capsulation
    private final WebDriver driver;
    private final JavascriptExecutor js;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    // Ads outside shortList selectors are capsuled and can be only accessed within this class
    // Once selector is defined, it cannot assign a new value
    private final By labelsTop = By.xpath("//div[@class='ads2023']/div[@class='item TOP ']");
    private final By labelsVip = By.xpath("//div[@class='ads2023']/div[@class='item VIP ']");
    private final By labelsUnlabeled = By.xpath("//div[@class='ads2023']/div[@class='item  ']");

    // Ads inside shortList
    private final By shortListVip = By.xpath("//div[@id='shortList6']/div[@class='item VIP ']");
    private final By shortListTop = By.xpath("//div[@id='shortList6']/div[@class='item TOP ']");
    private final By shortListUnlabeled = By.xpath("//div[@id='shortList6']/div[@class='item  ']");

    private final By nextPageButton = By.xpath("//a[@class='saveSlink next']");

    public String analyzeAllSearchResultsAndLog() throws IOException, InterruptedException {
        int vipCount = 0, topCount = 0, noLabelCount = 0;

        while (true) {
            // Create lists that will contain and count all add elements
            List<WebElement> vipElements = driver.findElements(labelsVip);
            List<WebElement> topElements = driver.findElements(labelsTop);
            List<WebElement> unlabeledElements = driver.findElements(labelsUnlabeled);

            List<WebElement> shortVip = driver.findElements(shortListVip);
            List<WebElement> shortTop = driver.findElements(shortListTop);
            List<WebElement> shortUnlabeled = driver.findElements(shortListUnlabeled);

            // Mark for visualization
            highlightElements(vipElements);
            highlightElements(topElements);
            highlightElements(unlabeledElements);
            highlightElements(shortVip);
            highlightElements(shortTop);
            highlightElements(shortUnlabeled);

            // Add ad to counters
            vipCount += vipElements.size() + shortVip.size();
            topCount += topElements.size() + shortTop.size();
            noLabelCount += unlabeledElements.size() + shortUnlabeled.size();

            // Navigation to next page
            if (!goToNextPage()) break;
        }

        return FileOutputUtil.saveSearchResultsToFile(vipCount, topCount, noLabelCount);
    }

    // Inside helper method, used within this class. Does not return anything only used to mark elements
    // Accept list of elements, which should be marked
    private void highlightElements(List<WebElement> elements) throws InterruptedException {
        for (WebElement el : elements) {
            js.executeScript("arguments[0].style.border='3px solid red'", el);
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'})", el);
            Thread.sleep(200);
        }
    }

    // Inside helper method, used within this class. Return true or false which is used to navigate next page
    private boolean goToNextPage() throws InterruptedException {
        try {
            WebElement nextBtn = driver.findElement(nextPageButton);
            if (nextBtn.isDisplayed() && nextBtn.isEnabled()) {
                js.executeScript("arguments[0].style.border='3px solid red'", nextBtn);
                js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'})", nextBtn);
                Thread.sleep(1000);
                nextBtn.click();
                Thread.sleep(2500);
                return true;
            }
        } catch (NoSuchElementException ignored) {}
        return false;
    }
}
