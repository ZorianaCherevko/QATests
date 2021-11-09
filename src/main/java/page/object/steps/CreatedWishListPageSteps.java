package page.object.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import page.object.pages.CreatedWishListPage;

public class CreatedWishListPageSteps {

    public CreatedWishListPage createdWishListPage = new CreatedWishListPage();

    public String getTextOfAmountOfWishLists(){
        return createdWishListPage.amountOfWishLists.shouldBe(Condition.appear).getText();
    }

    public SelenideElement getCreateWishListButton(){
        return createdWishListPage.createWishListButton.shouldBe(Condition.hidden);
    }

    public void changeWishListName(String keyword){
        createdWishListPage.settingsButton.shouldBe(Condition.visible).click();
        createdWishListPage.wishListNameInput.shouldBe(Condition.appear).clear();
        createdWishListPage.wishListNameInput.setValue(keyword);
        createdWishListPage.saveChangesButton.click();
    }

    public void makeWishListPrivate(){
        createdWishListPage.settingsButton.shouldBe(Condition.visible).click();
        createdWishListPage.makePrivateButton.click();
        createdWishListPage.saveChangesButton.click();
    }

    public String getTextOWishListName(){
        return createdWishListPage.wishListName.shouldBe(Condition.appear).getText();
    }

    public void deleteWishList(){
        createdWishListPage.settingsButton.shouldBe(Condition.visible).click();
        createdWishListPage.deleteWishButton.doubleClick();
    }

    public String getPrivacyTagText(){
        return createdWishListPage.privacyTag.shouldBe(Condition.appear).getText();
    }

    public void createNewWishList(){
       createdWishListPage.createWishListButton.shouldBe(Condition.visible).click();
       createdWishListPage.createWishListWithNameButton.shouldBe(Condition.visible).click();
    }
}
