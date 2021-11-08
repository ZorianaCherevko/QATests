package api.tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import steps.LogInSteps;
import utils.BaseTest;

import static consts.HttpCodes.*;
import static org.testng.Assert.assertEquals;
import static test.cred.RegisterCred.*;

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
