package page.object.tests;

import org.testng.annotations.Test;
import page.object.steps.*;
import page.object.utils.BaseTests;

import static org.testng.Assert.assertEquals;
import static page.object.test.cred.TestData.*;
import static page.object.test.cred.UserCred.EMAIL;
import static page.object.test.cred.UserCred.PASSWORD;

public class WishListTests extends BaseTests {

    public HomePageSteps getHomePageSteps = new HomePageSteps();
    public LogInPageSteps getLogInPageSteps = new LogInPageSteps();
    public AccountPageSteps getAccountPageSteps = new AccountPageSteps();
    public WishListPageSteps getWishListPageSteps = new WishListPageSteps();


    @Test
    public void checkThatUserCanCreateUpdateAndDeleteWishList() {
        getHomePageSteps.clickLogIn();
        getLogInPageSteps.logIn(EMAIL, PASSWORD);
        getAccountPageSteps.clickWishList();
        getWishListPageSteps.createNewWishList();
        assertEquals(getWishListPageSteps.getTextOfAmountOfWishLists(), EXPECTED_AMOUNT_OF_WISH_LISTS);
        getWishListPageSteps.makeWishListPrivate();
        assertEquals(getWishListPageSteps.getPrivacyTagText(), PRIVACY_TAG);
        getWishListPageSteps.deleteWishList();
        assertEquals(getWishListPageSteps.getTextOfWishPageCount(),EXPECTED_AMOUNT_OF_WISH_LISTS_AFTER_DELETING_ALL);


    }
}
