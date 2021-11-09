package page.object.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import page.object.pages.HomePage;

public class HomePageSteps {

    public HomePage homePage = new HomePage();

    public void searchByKeyword(String keyword){
        homePage.searchInput.sendKeys(keyword);
        homePage.searchButton.click();
    }

    public void inputByKeyword(String keyword){
        homePage.searchInput.sendKeys(keyword);
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

    public int getDropDownList(){
        return homePage.dropDownListResults.size();
    }


}
