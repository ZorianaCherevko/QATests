package page.object.utils;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

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
