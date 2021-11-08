package page.object.steps;

import com.codeborne.selenide.ElementsCollection;
import page.object.pages.SearchResultsPage;


public class SearchResultsPageSteps {

    public SearchResultsPage searchResultsPage = new SearchResultsPage();

    public ElementsCollection getSearchResultsList(){
        return searchResultsPage.searchResultProductsListText;
    }
}
