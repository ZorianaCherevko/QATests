package api.tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import api.steps.UserSteps;
import api.utils.BaseTest;

import static api.cred.UserCred.*;
import static org.testng.Assert.assertEquals;
import static api.consts.HttpCodes.*;

public class UserTests extends BaseTest {

    private final UserSteps userSteps = new UserSteps();

    @Test
    @Description("POST /api/users")
    public void checkThatCreateUserWithoutOneFieldReturns200(){
        assertEquals(userSteps.addNewUserWithoutAllFields(USER_NAME).getStatusCode(),CREATED);
    }

    @Test
    @Description("POST /api/users")
    public void checkThatCreateUserWithValidDataReturns200(){
        assertEquals(userSteps.addNewUser(USER_NAME, USER_JOB).getStatusCode(),CREATED);
    }

    @Test
    @Description("GET /api/users/{user-id}")
    public void checkThatGetUserByNotRegisteredIdReturns404(){
        assertEquals(userSteps.getInfoByUserId(NOT_REGISTERED_USER_ID).getStatusCode(),NOT_FOUND);
    }

    @Test
    @Description("GET /api/users/{user-id}")
    public void checkThatGetUserByIdReturns200(){
        assertEquals(userSteps.getInfoByUserId(USER_ID).getStatusCode(),OK);
    }

    @Test
    @Description("GET /api/users/{user-id}")
    public void checkThatGetUserByIdAsStringReturns200(){
        assertEquals(userSteps.getInfoByUserIdAsString(USER_STRING_ID).getStatusCode(),OK);
    }

    @Test
    @Description("PUT /api/users/{user-id}")
    public void checkThatUpdateUserByIdReturns200(){
        assertEquals(userSteps.updateNewUser(USER_NAME, UPDATED_USER_JOB, USER_ID).getStatusCode(),OK);
    }
}
