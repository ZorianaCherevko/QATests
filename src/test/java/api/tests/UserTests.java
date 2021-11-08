package api.tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import steps.UserSteps;
import utils.BaseTest;
import static org.testng.Assert.assertEquals;
import static test.cred.UserCred.*;
import static consts.HttpCodes.*;

public class UserTests extends BaseTest {

    private final UserSteps userSteps = new UserSteps();

    @Test
    @Description("POST /v2/pet")
    public void checkThatCreatePetWithValidDataReturns200(){
        assertEquals(userSteps.addNewUser(USER_NAME, USER_JOB).getStatusCode(),CREATED);
    }

    @Test
    @Description("GET /api/users/{user-id}")
    public void checkThatGetUserByIdReturns200(){
        assertEquals(userSteps.getInfoByUserId(USER_ID).getStatusCode(),OK);
    }

    @Test
    @Description("PUT /api/users/{user-id}")
    public void checkThatUpdateUserByIdReturns200(){
        assertEquals(userSteps.updateNewUser(USER_NAME, UPDATED_USER_JOB, USER_ID).getStatusCode(),OK);
    }
}
