package page.object.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import page.object.pages.CreatedWishListPage;

public class CreatedWishListPageSteps {

    public CreatedWishListPage createdWishListPage = new CreatedWishListPage();

    public String getTextOfAmountOfWishLists(){
        return createdWishListPage.amountOfWishLists.shouldBe(Condition.visible).getText();
    }

    public void makeWishListPrivate(){
        createdWishListPage.settingsButton.shouldBe(Condition.exist).click();
        createdWishListPage.makePrivateButton.click();
        createdWishListPage.saveChangesButton.click();
    }

    public void clickAddProducts(){
        createdWishListPage.addProductsButton.shouldBe(Condition.exist).click();
    }

    public void deleteWishList(){
        createdWishListPage.settingsButton.click();
        createdWishListPage.deleteWisDeleteButton.shouldBe(Condition.exist).click();
        createdWishListPage.deleteWisConfirmButton.shouldBe(Condition.exist).click();
    }

    public String getPrivacyTagText(){
        return createdWishListPage.privacyTag.shouldBe(Condition.appear).getText();
    }

    public void createNewWishList(){
       createdWishListPage.createWishListButton.shouldBe(Condition.visible).click();
       createdWishListPage.createWishListWithNameButton.click();
    }

    public int getWishItemTitlesSize(){
        return createdWishListPage.wishItemTitle.size();
    }

    public String getWishItemsCount(){
        return createdWishListPage.wishItemsCount.getText();
    }

    public SelenideElement getWishNameInput(){
       return createdWishListPage.wishNameInput.shouldBe(Condition.visible);
    }

    public void clickGoBackToWishLists(){
        createdWishListPage.goBackToWishLists.click();
    }
}
