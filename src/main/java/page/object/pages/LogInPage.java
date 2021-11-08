package page.object.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class LogInPage {

    public SelenideElement emailInput = $(xpath("//input[@id='username']"));
    public SelenideElement passwordInput = $(xpath("//input[@id='password']"));
    public SelenideElement logInButton = $(xpath("//input[@name='login']"));

}
