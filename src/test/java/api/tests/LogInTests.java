package api.tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import api.steps.LogInSteps;
import api.utils.BaseTest;

import static api.consts.HttpCodes.*;
import static api.cred.RegisterCred.*;
import static org.testng.Assert.assertEquals;

public class LogInTests extends BaseTest {

    private final LogInSteps logInSteps = new LogInSteps();

    @Test
    @Description("POST /api/login")
    public void checkThatCreateLogInWithValidDataReturns200(){
        assertEquals(logInSteps.addNewLogIn(USER_EMAIL, USER_PASSWORD ).getStatusCode(),OK);
    }

    @Test
    @Description("POST /api/login")
    public void checkThatCreateLogInWithoutPasswordReturns400(){
        assertEquals(logInSteps.addNewLogInWithoutPassword(USER_EMAIL).getStatusCode(),BAD_REQUEST);
    }
}
