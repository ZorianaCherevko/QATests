package page.object.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class WishListPage {

    public SelenideElement createWishListButton = $(xpath("//button[@class='wishlist-create-trigger wishlist-button wishlist-button-icon-before wishlist-button-primary']"));
    public SelenideElement wishListPageCount = $(xpath("//p[contains(text(),'Create')]//span[@class='wishlist-page-header-count']"));
    public SelenideElement createWishListWithNameButton = $(xpath("//button[@id='wishlist-create-button']"));
    public SelenideElement wishListNameInput = $(xpath("//input[@id='wishlist-create-name']"));
    public SelenideElement createdListButton = $(xpath("//div[@class='wishlist-account-item-info']"));

}
