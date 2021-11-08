package api.steps;

import api.builders.LogIn;
import api.utils.ApiUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import api.utils.BuilderUtil;

import static api.consts.Endpoints.*;

public class LogInSteps {

    private final BuilderUtil builderUtil = new BuilderUtil();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Step("Add a new log in")
    public Response addNewLogIn(String email, String  password){
        LogIn logIn = builderUtil.buildLogIn(email, password);
        return ApiUtil.post(CREATE_LOG_IN, objectMapper.writeValueAsString(logIn));
    }

    @SneakyThrows
    @Step("Add a new log in without a password field")
    public Response addNewLogInWithoutPassword(String email){
        LogIn logIn = builderUtil.buildLogInWithoutPassword(email);
        return ApiUtil.post(CREATE_LOG_IN, objectMapper.writeValueAsString(logIn));
    }
}
