package Tests;

import Pages.SearchPage;
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

        String expectedText = "Рубрика: Автомобили и Джипове, VW; Състояние: Нов, Употребяван, Повреден/ударен, Особености: 4x4, Подредени по: Марка/Модел/Цена";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

        // Check if body contain text
        String pageText = body.getText();

        Assert.assertTrue(pageText.contains(expectedText), "No such text, found by defined criteria");
    }
}