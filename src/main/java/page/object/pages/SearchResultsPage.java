package page.object.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class SearchResultsPage {

    public ElementsCollection searchResultProductsListText = $$(xpath("//div[@class='zg-product-title']"));
    public SelenideElement searchResultProduct = $$(xpath("//div[@class='zg-product-title']")).get(0);
    public SelenideElement searchResultsCount = $(xpath("//div[@class='zg-product-title']"));


}
