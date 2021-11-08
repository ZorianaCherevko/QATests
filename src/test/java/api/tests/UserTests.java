package api.tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import steps.UserSteps;
import utils.BaseTest;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static test.cred.UserCred.*;
import static consts.HttpCodes.*;

public class UserTests extends BaseTest {

    private final UserSteps userSteps = new UserSteps();

    @Test
    public void checkThatCreateUserWithoutOneFieldReturns200(){
        assertEquals(userSteps.addNewUserWithoutAllFields(USER_NAME).getStatusCode(),CREATED);
    }

    @Test
    public void checkThatCreateUserWithValidDataReturns200(){
        assertEquals(userSteps.addNewUser(USER_NAME, USER_JOB).getStatusCode(),CREATED);
    }

    @Test
    public void checkThatGetUserByNotRegisteredIdReturns404(){
        assertEquals(userSteps.getInfoByUserId(NOT_REGISTERED_USER_ID).getStatusCode(),NOT_FOUND);
    }

    @Test
    public void checkThatGetUserByIdReturns200(){
        assertEquals(userSteps.getInfoByUserId(USER_ID).getStatusCode(),OK);
    }

    @Test
    public void checkThatGetUserByIdAsStringReturns200(){
        assertEquals(userSteps.getInfoByUserIdAsString(USER_STRING_ID).getStatusCode(),NOT_FOUND);
    }

    @Test
    public void checkThatUpdateUserByIdReturns200(){
        assertEquals(userSteps.updateNewUser(USER_NAME, UPDATED_USER_JOB, USER_ID).getStatusCode(),OK);
    }
}
