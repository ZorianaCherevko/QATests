package steps;

import builders.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import utils.BuilderUtil;

import static consts.Endpoints.*;
import static utils.ApiUtil.*;

public class UserSteps {

    private final BuilderUtil builderUtil = new BuilderUtil();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public Response addNewUser(String name, String  job){
        User user = builderUtil.buildUser(name, job);
        return post(CREATE_USER, objectMapper.writeValueAsString(user));
    }

    @SneakyThrows
    @Step("Add a new user without one field")
    public Response addNewUserWithoutAllFields(String name){
        User user = builderUtil.buildMinUser(name);
        return post(CREATE_USER, objectMapper.writeValueAsString(user));
    }

    @SneakyThrows
    @Step("Get a user info by a user id")
    public Response getInfoByUserId(int id){
        return get(GET_USER, id);
    }

    @SneakyThrows
    @Step("Get a user info by a user id as a String value")
    public Response getInfoByUserIdAsString(String id){
        return get(GET_USER, id);
    }

    @SneakyThrows
    @Step("Update a user info by a user id")
    public Response updateNewUser(String name, String  newJob, int id){

        User user = builderUtil.buildUser(name, newJob);
        return put(UPDATE_USER, objectMapper.writeValueAsString(user),id);
    }



}
