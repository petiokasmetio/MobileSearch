package Tests;

import Pages.SearchPage;
import Pages.SearchResultsPage;
import org.testng.annotations.Test;
import java.io.IOException;

public class SearchResultsTest extends BaseClass {

    @Test(priority = 3)
    public void analyzeAllPaginatedSearchResults() throws IOException, InterruptedException {
        SearchPage search = new SearchPage(driver);
        search.clickSearchMenuButton();
        search.selectVWModel();
        search.selectFourWheelCheckboxOption();
        search.clickSearchButtonAfterCriteriaSelection();

        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        String outputPath = resultsPage.analyzeAllSearchResultsAndLog();

        System.out.println("Analysis done, file output is saved: " + outputPath);
    }
}