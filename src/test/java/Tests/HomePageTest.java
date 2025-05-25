package Tests;

import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

    @Test(priority = 1)
    public void testVerifyHomaPageTitleWithWait() {
        HomePage home = new HomePage(driver);
        String expectedTitle = "Mobile.bg – Българският автомобилен пазар: нови и втора употреба автомобили, " +
                "джипове, камиони, мотоциклети...";
        String actualTitle = home.waitForHomePageTitle(expectedTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "No homepage title match");
    }
    //Test above will fail intentionally:
    //Expected :Mobile.bg – Българският автомобилен пазар: нови и втора употреба автомобили, джипове, камиони, мотоциклети...
    //Actual   :Намери обяви за продажба на Автомобили и Джипове в Mobile.bg

    @Test(priority = 1)
    public void testClickSearchButtonNavigatesToSearchPage() {
        HomePage home = new HomePage(driver);
        home.clickSearchMenu();
        Assert.assertTrue(driver.getCurrentUrl().contains("search"));
    }
}