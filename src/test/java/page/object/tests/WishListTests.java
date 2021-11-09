package page.object.tests;

import org.testng.annotations.Test;
import page.object.steps.*;
import page.object.utils.BaseTests;

import static org.testng.Assert.*;
import static page.object.test.cred.WishListData.*;
import static page.object.test.cred.UserCred.EMAIL;
import static page.object.test.cred.UserCred.PASSWORD;

public class WishListTests extends BaseTests {

    public HomePageSteps getHomePageSteps = new HomePageSteps();
    public LogInPageSteps getLogInPageSteps = new LogInPageSteps();
    public AccountPageSteps getAccountPageSteps = new AccountPageSteps();
    public WishListPageSteps getWishListPageSteps = new WishListPageSteps();
    public CreatedWishListPageSteps getCreatedWishListPageSteps = new CreatedWishListPageSteps();


    @Test
    public void checkCreateWishList() {
        getHomePageSteps.clickLogIn();
        getLogInPageSteps.logIn(EMAIL, PASSWORD);
        getAccountPageSteps.clickWishList();
        getWishListPageSteps.createNewWishList();
        assertEquals(getCreatedWishListPageSteps.getTextOfAmountOfWishLists(), EXPECTED_AMOUNT_OF_WISH_LISTS);
    }

    @Test
    public void checkUpdateWishList() {
        getHomePageSteps.clickLogIn();
        getLogInPageSteps.logIn(EMAIL, PASSWORD);
        getAccountPageSteps.clickWishList();
        getWishListPageSteps.clickCreatedList();
        getCreatedWishListPageSteps.makeWishListPrivate();
        assertEquals(getCreatedWishListPageSteps.getPrivacyTagText(), PRIVACY_TAG);
    }
    @Test
    public void checkDeleteWishList() {
        getHomePageSteps.clickLogIn();
        getLogInPageSteps.logIn(EMAIL, PASSWORD);
        getAccountPageSteps.clickWishList();
        getWishListPageSteps.clickCreatedList();
        getCreatedWishListPageSteps.deleteWishList();
        assertEquals(getWishListPageSteps.getTextOfWishPageCount(),EXPECTED_AMOUNT_OF_WISH_LISTS_AFTER_DELETING_ALL);
    }

    @Test
    public void checkCreateMoreThanFiveWishList() {
        getHomePageSteps.clickLogIn();
        getLogInPageSteps.logIn(EMAIL, PASSWORD);
        getAccountPageSteps.clickWishList();
        getWishListPageSteps.createNewWishList();
        for(int i=1;i<5;i++) {
            getCreatedWishListPageSteps.createNewWishList();
        }
        assertFalse(getCreatedWishListPageSteps.getCreateWishListButton().isDisplayed());
    }

    @Test
    public void checkCreateWishListt() {
        getHomePageSteps.clickLogIn();
        getLogInPageSteps.logIn(EMAIL, PASSWORD);
        getAccountPageSteps.clickWishList();
        getWishListPageSteps.createNewWishList();
        getCreatedWishListPageSteps.changeWishListName("bla bla bla");
    }
}

