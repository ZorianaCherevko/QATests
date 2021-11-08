package api.tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import api.steps.RegisterSteps;
import api.utils.BaseTest;
import static api.consts.HttpCodes.*;
import static api.cred.RegisterCred.*;

import static org.testng.Assert.assertEquals;

public class RegisterTests extends BaseTest {

    private final RegisterSteps registerSteps = new RegisterSteps();

    @Test
    @Description("POST /api/register")
    public void checkThatCreateRegisterWithValidDataReturns200(){
        assertEquals(registerSteps.addNewRegister(USER_EMAIL, USER_PASSWORD ).getStatusCode(),OK);
    }

    @Test
    @Description("POST /api/register")
    public void checkThatCreateRegisterWithoutPasswordReturns400(){
        assertEquals(registerSteps.addNewRegisterWithoutPassword(USER_EMAIL).getStatusCode(),BAD_REQUEST);
    }




}
