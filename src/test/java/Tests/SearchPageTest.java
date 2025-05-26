package Tests;

import Pages.SearchPage;
import Utilities.FileOutputUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchPageTest extends BaseClass {

    @Test(priority = 2)
    public void testVerifyVWsearchResult() throws InterruptedException {
        SearchPage search = new SearchPage(driver);
        search.clickSearchMenuButton();
        search.selectVWModel();
        search.selectFourWheelCheckboxOption();
        search.clickSearchButtonAfterCriteriaSelection();

        // Проверка на съдържание
        String expectedText = "Рубрика: Автомобили и Джипове, VW; Състояние: Нов, Употребяван, Повреден/ударен, Особености: 4x4, Подредени по: Марка/Модел/Цена";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
        String pageText = body.getText();
        Assert.assertTrue(pageText.contains(expectedText), "No such text, found by defined criteria");

        // Get total VW ads
        String totalResultsText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'от общо')]"))).getText();
        int count = extractCountFromText(totalResultsText);

        // Save in log output
        try {
            FileOutputUtil.appendTotalSearchResults(count);
        } catch (Exception e) {
            System.err.println("Failed to write total search result to file: " + e.getMessage());
        }
    }

    // Helper method to get number after "от общо"
    private int extractCountFromText(String text) {
        String[] parts = text.split("от общо");
        if (parts.length > 1) {
            String numberPart = parts[1].replaceAll("[^\\d]", "");
            return Integer.parseInt(numberPart);
        } else {
            throw new IllegalArgumentException("Text does not contain 'от общо': " + text);
        }
    }
}
