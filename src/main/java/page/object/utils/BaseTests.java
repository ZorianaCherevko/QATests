package page.object.utils;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import page.object.steps.AccountPageSteps;
import page.object.steps.HomePageSteps;
import page.object.steps.LogInPageSteps;
import page.object.steps.WishListPageSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static page.object.test.cred.Urls.BASE_URL;
import static page.object.test.cred.UserCred.EMAIL;
import static page.object.test.cred.UserCred.PASSWORD;

public class BaseTests {

    private static final String URL ="https://www.board-game.co.uk/";

    @BeforeMethod
    public void profileSetUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.startMaximized = true;
        open(URL);
    }

    @AfterMethod
    public void tearDown(){
        closeWebDriver();
    }


}
