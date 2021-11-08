package steps;

import builders.LogIn;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import utils.BuilderUtil;

import static consts.Endpoints.*;
import static utils.ApiUtil.post;

public class LogInSteps {

    private final BuilderUtil builderUtil = new BuilderUtil();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Step("Add a new log in")
    public Response addNewLogIn(String email, String  password){

        LogIn logIn = builderUtil.buildLogIn(email, password);
        return post(CREATE_LOG_IN, objectMapper.writeValueAsString(logIn));
    }
}
