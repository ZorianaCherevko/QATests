package page.object.steps;

import page.object.pages.HomePage;

public class HomePageSteps {

    public HomePage homePage = new HomePage();

    public void searchByKeyword(String keyword){
        homePage.searchInput.sendKeys(keyword);
        homePage.searchButton.click();
    }

    public void clickLogIn(){
        homePage.logInButton.click();
    }


}
