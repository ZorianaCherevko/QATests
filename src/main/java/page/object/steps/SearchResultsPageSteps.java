package page.object.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import page.object.pages.SearchResultsPage;


public class SearchResultsPageSteps {

    public SearchResultsPage searchResultsPage = new SearchResultsPage();

    public ElementsCollection getSearchResultsList(){
        return searchResultsPage.searchResultProductsListText;
    }

    public void clickThreeAddToWishlistButtons(){
        for(int i = 1; i<=3; i++) {
            searchResultsPage.addToWishListButtons.get(i).click();
            searchResultsPage.wishListCheckbox.shouldBe(Condition.visible).click();
            searchResultsPage.saveWishListButton.click();
        }
    }

    public void clickGoToWishList(){
        searchResultsPage.goToWishListButton.click();
    }
    public void clickFirstSearchResult(){
        searchResultsPage.searchResultProduct.click();
    }

    public String getTextOfSearchResultsCount(){
        return searchResultsPage.searchResultsCount.shouldBe(Condition.appear).getText();
    }

    public int getSearchResultsListSize(){
        return searchResultsPage.searchResultProductsListText.size();
    }


}
