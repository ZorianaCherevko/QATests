package page.object.pages;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class SearchResultsPage {

    public ElementsCollection searchResultProductsListText = $$(xpath("//div[@class='zg-product-title']"));


}
