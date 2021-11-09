package page.object.steps;

import com.codeborne.selenide.Condition;
import page.object.pages.AccountPage;

public class AccountPageSteps {

    public AccountPage accountPage = new AccountPage();

    public void clickWishList(){
        accountPage.wishListButton.shouldBe(Condition.visible).click();
    }
}
