package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SearchResultsPage {
    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    By labelsTop = By.xpath("//div[@class='ads2023']/div[@class='item TOP ']");
    By labelsVip = By.xpath("//div[@class='ads2023']/div[@class='item VIP ']");
    By allItemsLeftover = By.xpath("//div[@class='ads2023']/div[@class='item  ']");
    By nextPageButton = By.xpath("//a[@class='saveSlink next']");

    public void analyzeAllSearchResultsAndLog() throws IOException, InterruptedException {
        int vipCount = 0, topCount = 0, noLabelCount = 0;
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while (true) {
            // Get all ad elements
            List<WebElement> vipElements = driver.findElements(labelsVip);
            List<WebElement> topElements = driver.findElements(labelsTop);
            List<WebElement> allElements = driver.findElements(allItemsLeftover);

            // Mark VIP ad elements
            for (WebElement el : vipElements) {
                js.executeScript("arguments[0].style.border='3px solid red'", el);
                js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'})", el);
                Thread.sleep(300); // Short break to visualize
            }

            // Mark TOP ad elements
            for (WebElement el : topElements) {
                js.executeScript("arguments[0].style.border='3px solid red'", el);
                js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'})", el);
                Thread.sleep(300); // Short break to visualize
            }

            // Mark common ad elements
            for (WebElement el : allElements) {
                js.executeScript("arguments[0].style.border='3px solid red'", el);
                js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'})", el);
                Thread.sleep(300); // Short break to visualize
            }

            // Counters for each ad elements
            vipCount += vipElements.size();
            topCount += topElements.size();
            noLabelCount += allElements.size();

            // Short break before scroll to the top of the page
            Thread.sleep(500);

            // Scroll to the top of the page
            js.executeScript("window.scrollTo(0, 0);");
            Thread.sleep(800);

            // Try to find next page button
            try {
                WebElement nextBtn = driver.findElement(nextPageButton);
                if (nextBtn.isDisplayed() && nextBtn.isEnabled()) {
                    // Mark next button when is visible
                    js.executeScript("arguments[0].style.border='3px solid red'", nextBtn);
                    js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'})", nextBtn);
                    Thread.sleep(1000);

                    // Click next button
                    nextBtn.click();
                    Thread.sleep(2500); // Short break after next page load
                } else {
                    break;
                }
            } catch (NoSuchElementException | InterruptedException e) {
                break;
            }
        }

        // Define file path in project directory
        String baseOutputDirPath = "C:\\Users\\Elitebook\\IdeaProjects\\MobileSearch\\output";
        File baseDir = new File(baseOutputDirPath);

        // Create base directory in case does not exist
        if (!baseDir.exists()) {
            baseDir.mkdirs();
        }
        // Find nex directory output number (output_1, output_2, ...)
        int dirIndex = 1;
        File newDir;
        while (true) {
            newDir = new File(baseDir, "output_" + dirIndex);
            if (!newDir.exists()) {
                newDir.mkdirs();
                break;
            }
            dirIndex++;
        }

        // Full path to new folder
        File logFile = new File(newDir, "full_search_result_analysis.txt");

        // Write to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile))) {
            writer.write("== Results from ad`s ==\n");
            writer.write("VIP ads: " + vipCount + "\n");
            writer.write("TOP ads: " + topCount + "\n");
            writer.write("Ads without label: " + noLabelCount + "\n");
            writer.write("Total ads: " + (vipCount + topCount + noLabelCount) + "\n");
        }
    }
}
