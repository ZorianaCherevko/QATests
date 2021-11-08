package page.object.steps;

import page.object.pages.LogInPage;

public class LogInPageSteps {

    public LogInPage logInPage = new LogInPage();

    public void logIn(String email, String password){
        logInPage.emailInput.sendKeys(email);
        logInPage.passwordInput.sendKeys(password);
        logInPage.logInButton.click();
    }
}
