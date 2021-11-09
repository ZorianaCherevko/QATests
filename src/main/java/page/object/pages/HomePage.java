package page.object.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class HomePage {

    public SelenideElement searchInput = $(xpath("//input[@type='search']"));
    public SelenideElement searchButton = $(xpath("//form/button"));
    public SelenideElement logInButton = $(xpath("//div[@class='zg-header-menu']//a[contains(@href,'account')]"));
    public ElementsCollection dropDownListResults = $$(xpath("//div[@id='zgs-dropdown-results']//a[contains(@href,'search-results/?query')]"));
}
