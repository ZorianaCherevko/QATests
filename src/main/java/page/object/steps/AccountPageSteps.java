package page.object.steps;

import page.object.pages.AccountPage;

public class AccountPageSteps {

    public AccountPage accountPage = new AccountPage();

    public void clickWishList(){
        accountPage.wishListButton.click();
    }
}
