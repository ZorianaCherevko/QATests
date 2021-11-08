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
    @Step("Add a new user")
    public Response addNewUser(String name, String  job){

        User user = builderUtil.buildUser(name, job);
        return post(CREATE_USER, objectMapper.writeValueAsString(user));
    }

    @SneakyThrows
    @Step("Get a user")
    public Response getInfoByUserId(int id){
        return get(GET_USER, id);
    }

    @SneakyThrows
    @Step("Update a user")
    public Response updateNewUser(String name, String  newJob, int id){

        User user = builderUtil.buildUser(name, newJob);
        return put(UPDATE_USER, objectMapper.writeValueAsString(user),id);
    }



}
