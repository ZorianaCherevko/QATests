package api.steps;

import api.builders.User;
import api.utils.ApiUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import api.utils.BuilderUtil;

import static api.consts.Endpoints.*;
import static api.utils.ApiUtil.*;

public class UserSteps {

    private final BuilderUtil builderUtil = new BuilderUtil();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public Response addNewUser(String name, String  job){
        User user = builderUtil.buildUser(name, job);
        return ApiUtil.post(CREATE_USER, objectMapper.writeValueAsString(user));
    }

    @SneakyThrows
    @Step("Add a new user without one field")
    public Response addNewUserWithoutAllFields(String name){
        User user = builderUtil.buildMinUser(name);
        return ApiUtil.post(CREATE_USER, objectMapper.writeValueAsString(user));
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
        return ApiUtil.put(UPDATE_USER, objectMapper.writeValueAsString(user),id);
    }



}
