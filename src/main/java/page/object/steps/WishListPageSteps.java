package page.object.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import page.object.pages.CreatedWishListPage;
import page.object.pages.WishListPage;

import java.util.Objects;

public class WishListPageSteps {

    public WishListPage wishListPage = new WishListPage();

    public CreatedWishListPage createdWishListPage = new CreatedWishListPage();

    public void createNewWishList(){
        wishListPage.createWishListButton.shouldBe(Condition.visible).click();
        wishListPage.createWishListWithNameButton.shouldBe(Condition.visible).click();
    }

    public void clickCreatedList(){
        wishListPage.createdListButton.shouldBe(Condition.visible).click();
    }

    public String getTextOfWishPageCount(){
        return wishListPage.wishListPageCount.shouldBe(Condition.exist).getText();
    }

    public SelenideElement getWishPageCount(){
        return wishListPage.wishListPageCount.shouldBe(Condition.visible);
    }

    public int getListHeadersCount(){
        return wishListPage.createdListHeadersButton.size();
    }

    public void deleteAllWishLists(){
        //wishListPage.createdListHeaderButton.shouldBe(Condition.visible);
        while(!Objects.equals(getTextOfWishPageCount(), "(0/5)")) {
            wishListPage.createdListHeaderButton.click();
            createdWishListPage.settingsButton.click();
            createdWishListPage.deleteWisDeleteButton.click();
            createdWishListPage.deleteWisConfirmButton.click();
        }
    }

}
