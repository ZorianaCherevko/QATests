package page.object.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class CreatedWishListPage {

    public SelenideElement amountOfWishLists = $(xpath("//span[@class='wishlist-list-count']"));
    public SelenideElement settingsButton = $(xpath("//a[@class='wishlist-edit-trigger wishlist-action-bar-button icon-before']"));
    public SelenideElement wishListNameInput = $(xpath("//input[@id='wishlist-create-name']"));
    public SelenideElement saveChangesButton = $(xpath("//button[@id='wishlist-edit-button-save']"));
    public SelenideElement wishListName = $(xpath("//div[@class='wishlist-page-header-info']//span[@class='wishlist-page-header-name']"));
    public SelenideElement deleteWishButton = $(xpath("//button[@id='wishlist-edit-delete-trigger']"));
    public SelenideElement makePrivateButton = $(xpath("//input[@id='wishlist-edit-private']"));
    public SelenideElement privacyTag = $(xpath("//span[@class='wishlist-privacy-private active']"));
    public SelenideElement createWishListWithNameButton = $(xpath("//button[@id='wishlist-create-button']"));
    public SelenideElement addProductsButton = $(xpath("//div[@class='wishlist-empty-text']//a[contains(@href,'board')]"));
    public SelenideElement createWishListButton = $(xpath("//button[@class='wishlist-create-trigger wishlist-button wishlist-button-icon-before wishlist-button-primary']"));
}
