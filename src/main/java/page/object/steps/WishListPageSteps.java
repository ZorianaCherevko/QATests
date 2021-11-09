package page.object.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import page.object.pages.WishListPage;

public class WishListPageSteps {

    public WishListPage wishListPage = new WishListPage();

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

}
