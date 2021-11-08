package utils;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private final String BASE_URL = "https://reqres.in/";

    @BeforeTest
    public void BaseTest() {
        RestAssured.baseURI = BASE_URL;
    }
}
