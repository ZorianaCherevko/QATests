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
        wishListPage.createWishListButton.shouldBe(Condition.exist).click();
        wishListPage.createWishListWithNameButton.shouldBe(Condition.exist).click();
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
        while(!Objects.equals(getTextOfWishPageCount(), "(0/5)")) {
            wishListPage.createdListHeaderButton.click();
            createdWishListPage.settingsButton.click();
            createdWishListPage.deleteWisDeleteButton.shouldBe(Condition.exist).click();
            createdWishListPage.deleteWisConfirmButton.shouldBe(Condition.exist).click();
        }
    }

    public SelenideElement getCreateNewWishListButton(){
        return wishListPage.createWishListButton.shouldNotBe(Condition.exist);
    }

    public void createNewWishListFive(){
        wishListPage.createWishListButton.shouldBe(Condition.exist).click();
        wishListPage.createWishListWithNameButton.shouldBe(Condition.visible).click();
    }


}
