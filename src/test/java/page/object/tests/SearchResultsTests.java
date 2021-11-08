package page.object.tests;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;
import page.object.steps.*;
import page.object.utils.BaseTests;


import static org.testng.Assert.assertTrue;
import static page.object.test.cred.TestData.SEARCH_KEYWORD;


public class SearchResultsTests extends BaseTests {

    public HomePageSteps getHomePageSteps = new HomePageSteps();
    public SearchResultsPageSteps getSearchResultsPageSteps = new SearchResultsPageSteps();

    @Test
    public void checkThatSearchResultsContainSearchWord() {
        getHomePageSteps.searchByKeyword(SEARCH_KEYWORD);
        for (SelenideElement element : getSearchResultsPageSteps.getSearchResultsList()) {
           assertTrue(element.getText().contains(SEARCH_KEYWORD));
        }
    }

}
