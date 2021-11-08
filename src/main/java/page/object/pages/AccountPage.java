package page.object.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class AccountPage {

    public SelenideElement wishListButton = $(xpath("//a[@class='my-wishlist']"));

}
