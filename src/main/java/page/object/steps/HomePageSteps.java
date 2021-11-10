package page.object.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import page.object.pages.HomePage;

public class HomePageSteps {

    public HomePage homePage = new HomePage();

    public void searchByKeyword(String keyword){
        homePage.searchInput.sendKeys(keyword);
        homePage.searchButton.shouldBe(Condition.visible).click();
    }

    public void inputByKeyword(String keyword){
        homePage.searchInput.sendKeys(keyword);
    }


    public void clickClearHistory(){
        homePage.clearHistoryButton.click();
    }

    public void clickSearchButton(){
        homePage.searchButton.click();
    }

    public void clickSearchInput(){
        homePage.searchInput.click();
    }

    public void clickLogIn(){
        homePage.logInButton.click();
    }

    public int getDropDownListSize(){
        return homePage.dropDownListResults.size();
    }

    public SelenideElement getDropDownList(){
        return homePage.dropDownList;
    }


    public SelenideElement getSearchInput(){
        return homePage.searchInput;
    }

    public void deleteInputText(){
        while(!homePage.searchInput.is(Condition.empty)) {
            homePage.searchInput.sendKeys(Keys.BACK_SPACE);
        }
    }


}
