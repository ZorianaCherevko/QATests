package steps;

import builders.Register;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import utils.BuilderUtil;

import static consts.Endpoints.*;
import static utils.ApiUtil.post;

public class RegisterSteps {

    private final BuilderUtil builderUtil = new BuilderUtil();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Step("Add a new register")
    public Response addNewRegister(String email, String  password){

        Register register = builderUtil.buildRegister(email, password);
        return post(CREATE_REGISTER, objectMapper.writeValueAsString(register));
    }

    @SneakyThrows
    @Step("Add a new register without a password field")
    public Response addNewRegisterWithoutPassword(String email){

        Register register = builderUtil.buildRegisterWithoutPassword(email);
        return post(CREATE_REGISTER, objectMapper.writeValueAsString(register));
    }
}
