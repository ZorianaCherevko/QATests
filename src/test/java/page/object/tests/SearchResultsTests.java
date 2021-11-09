package page.object.tests;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;
import page.object.steps.*;
import page.object.utils.BaseTests;

import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.*;
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
    public void checkThatSearchHistoryIsDisplayed() {
        getHomePageSteps.searchByKeyword(SEARCH_KEYWORD);
        getHomePageSteps.searchByKeyword("King");
        getHomePageSteps.clickSearchInput();
        assertEquals(getHomePageSteps.getDropDownListSize(), 2);
    }

    @Test
    public void checkThatSearchClearHistoryWorks() {
        getHomePageSteps.searchByKeyword(SEARCH_KEYWORD);
        getHomePageSteps.searchByKeyword("King");
        getHomePageSteps.clickSearchInput();
        getHomePageSteps.clickClearHistory();
        getHomePageSteps.clickSearchInput();
        assertFalse(getHomePageSteps.getDropDownList().isDisplayed());
    }

    @Test
    public void checkThatSearchResultsAreNotDisplayedWhenEnteringSpecialSymbols() {
        getHomePageSteps.searchByKeyword(SEARCH_KEYWORD_ONLY_SYMBOLS);
        assertEquals(getWebDriver().getCurrentUrl(), BASE_URL);
    }

    @Test
    public void checkThatSearchIsPossibleWhenEnteringNumbers() {
        getHomePageSteps.searchByKeyword(SEARCH_KEYWORD_ONLY_NUMBERS);
        assertTrue(getWebDriver().getCurrentUrl().contains(QUERY_URL));
    }

    @Test
    public void checkThatSearchIsPossibleWhenEnteringLetterAndNumbers() {
        getHomePageSteps.searchByKeyword(SEARCH_KEYWORD_NUMBERS_LETTERS);
        assertTrue(getWebDriver().getCurrentUrl().contains(QUERY_URL));
    }

    @Test
    public void checkThatSearchIsPossibleWhenEnteringLetterNumbersAndSymbols() {
        getHomePageSteps.searchByKeyword(SEARCH_KEYWORD_NUMBERS_LETTERS_SYMBOLS);
        assertTrue(getWebDriver().getCurrentUrl().contains(QUERY_URL));
    }

    @Test
    public void checkThatSearchResultsAreMaintainedAfterNavigatingBack() {
        getHomePageSteps.searchByKeyword(SEARCH_KEYWORD);
        getSearchResultsPageSteps.clickFirstSearchResult();
        back();
        for (SelenideElement element : getSearchResultsPageSteps.getSearchResultsList()) {
            assertTrue(element.getText().contains(SEARCH_KEYWORD));
        }
    }

    @Test
    public void checkThatSearchResultsCountMatchesSizeofSearhResultsList() {
        getHomePageSteps.searchByKeyword(SEARCH_KEYWORD);
        assertEquals(getSearchResultsPageSteps.getSearchResultsListSize(),5 );
    }


}
