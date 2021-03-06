package page.object.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import page.object.steps.*;
import page.object.utils.BaseTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.*;
import static page.object.test.cred.SearchKeywords.*;
import static page.object.test.cred.Urls.*;


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
            getHomePageSteps.searchByKeyword(SEARCH_CHAR);
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
        getHomePageSteps.searchByKeyword(SECOND_SEARCH_KEYWORD);
        getHomePageSteps.clickSearchInput();
        assertEquals(getHomePageSteps.getDropDownListSize(), 2);
    }

    @Test
    public void checkThatClearHistoryWorks() {
        getHomePageSteps.searchByKeyword(SEARCH_KEYWORD);
        getHomePageSteps.searchByKeyword(SECOND_SEARCH_KEYWORD);
        getHomePageSteps.clickSearchInput();
        getHomePageSteps.getDropDownList();
        getHomePageSteps.clickClearHistory();
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
    public void checkThatSearchResultsCountMatchesSizeofSearchResultsList() {
        getHomePageSteps.searchByKeyword(SEARCH_KEYWORD);
        assertEquals(getSearchResultsPageSteps.getSearchResultsListSize(),5 );
    }

    @Test
    public void checkUserCanEraseInput() {
        getHomePageSteps.searchByKeyword(SEARCH_KEYWORD);
        getHomePageSteps.deleteInputText();
        assertTrue(getHomePageSteps.getSearchInput().is(Condition.empty));
    }

    @Test
    public void checkThatSpacesNotAffectSearchResults() {
        getHomePageSteps.searchByKeyword(SEARCH_KEYWORD_WITH_SPACES);
        for (SelenideElement element : getSearchResultsPageSteps.getSearchResultsList()) {
            assertTrue(element.getText().contains(SEARCH_KEYWORD));
        }
    }

    @Test
    public void checkThatKeywordsWithoutSpacesShowNotRelevantResults() {
        getHomePageSteps.searchByKeyword(SEARCH_KEYWORD_NO_SPACES);
        for (SelenideElement element : getSearchResultsPageSteps.getSearchResultsList()) {
            assertFalse(element.getText().contains(SEARCH_KEYWORD));
        }
    }

}
