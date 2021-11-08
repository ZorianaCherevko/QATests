package api.steps;

import api.builders.Register;
import api.utils.ApiUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import api.utils.BuilderUtil;

import static api.consts.Endpoints.*;

public class RegisterSteps {

    private final BuilderUtil builderUtil = new BuilderUtil();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Step("Add a new register")
    public Response addNewRegister(String email, String  password){

        Register register = builderUtil.buildRegister(email, password);
        return ApiUtil.post(CREATE_REGISTER, objectMapper.writeValueAsString(register));
    }

    @SneakyThrows
    @Step("Add a new register without a password field")
    public Response addNewRegisterWithoutPassword(String email){

        Register register = builderUtil.buildRegisterWithoutPassword(email);
        return ApiUtil.post(CREATE_REGISTER, objectMapper.writeValueAsString(register));
    }
}
