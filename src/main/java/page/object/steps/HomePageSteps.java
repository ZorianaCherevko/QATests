package page.object.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import page.object.pages.HomePage;

public class HomePageSteps {

    public HomePage homePage = new HomePage();

    public void searchByKeyword(String keyword){
        homePage.searchInput.sendKeys(keyword);
        homePage.searchButton.click();
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


}
