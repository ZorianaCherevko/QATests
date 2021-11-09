package page.object.tests;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;
import page.object.steps.*;
import page.object.utils.BaseTests;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static page.object.test.cred.TestData.*;


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

    @Test
    public void checkThatUserIsNotRedirectedWithoutEnteringKeywordsInSearchBox() {
        getHomePageSteps.clickSearchButton();
        assertEquals(getWebDriver().getCurrentUrl(), BASE_URL);
    }

    @Test
    public void checkThatSearchResultsAreNotDisplayedWithLessThanMinCharsLimit() {
        for (int i=1;i<=2;i++){
            getHomePageSteps.searchByKeyword("a");
            assertEquals(getWebDriver().getCurrentUrl(), BASE_URL);
        }
    }

    @Test
    public void checkThatSymbolsNotEffectOnRelevantSearchResults() {
        getHomePageSteps.searchByKeyword(SEARCH_KEYWORD_WITH_SYMBOLS);
        for (SelenideElement element : getSearchResultsPageSteps.getSearchResultsList()) {
            assertTrue(element.getText().contains(SEARCH_KEYWORD));
        }
    }

    @Test
    public void checkThatSymbolsNotEffectOnRelevantSearchReslts() {
        getHomePageSteps.searchByKeyword(SEARCH_KEYWORD);
        getHomePageSteps.searchByKeyword("King");
        getHomePageSteps.clickSearchInput();
        assertEquals(getHomePageSteps.getDropDownList(), 2);
    }


}
