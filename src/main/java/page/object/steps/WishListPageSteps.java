package page.object.steps;

import com.codeborne.selenide.Condition;
import page.object.pages.WishListPage;

public class WishListPageSteps {

    public WishListPage wishListPage = new WishListPage();

    public void createNewWishList(){
        wishListPage.createWishListButton.shouldBe(Condition.visible).click();
        wishListPage.createWishListWithNameButton.shouldBe(Condition.visible).click();
    }

    public String getTextOfAmountOfWishLists(){
        return wishListPage.amountOfWishLists.shouldBe(Condition.appear).getText();
    }


    public void makeWishListPrivate(){
        wishListPage.settingsButton.shouldBe(Condition.visible).click();
        wishListPage.makePrivateButton.click();
        wishListPage.saveChangesButton.click();
    }

    public void deleteWishList(){
        wishListPage.settingsButton.shouldBe(Condition.visible).click();
        wishListPage.deleteWishButton.doubleClick();
    }

    public String getTextOfWishPageCount(){
        return wishListPage.wishListPageCount.shouldBe(Condition.appear).getText();
    }
    public String getPrivacyTagText(){
        return wishListPage.privacyTag.shouldBe(Condition.appear).getText();
    }


}
