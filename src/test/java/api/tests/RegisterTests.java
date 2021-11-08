package api.tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import steps.RegisterSteps;
import utils.BaseTest;

import static consts.HttpCodes.*;
import static org.testng.Assert.assertEquals;
import static test.cred.RegisterCred.*;

public class RegisterTests extends BaseTest {

    private final RegisterSteps registerSteps = new RegisterSteps();

    @Test
    @Description("POST /api/register")
    public void checkThatCreateRegisterWithValidDataReturns200(){
        assertEquals(registerSteps.addNewRegister(USER_EMAIL, USER_PASSWORD ).getStatusCode(),OK);
    }




}
