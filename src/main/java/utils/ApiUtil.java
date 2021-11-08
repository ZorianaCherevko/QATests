package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiUtil {

    public static Response post(String endpoint, Object body){
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.contentType(ContentType.JSON);
        requestSpec.accept(ContentType.JSON);
        requestSpec.body(body).log().all();

        Response resp = requestSpec.post(endpoint);
        return resp;
    }

    public static Response put(String endpoint, Object body, int id){
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.contentType(ContentType.JSON);
        requestSpec.accept(ContentType.JSON);
        requestSpec.pathParam("user-id", id );
        requestSpec.body(body).log().all();

        Response resp = requestSpec.put(endpoint);
        return resp;
    }

    public static Response get(String endpoint, int id){
        RequestSpecification requestSpec = RestAssured.given();
        requestSpec.contentType(ContentType.JSON);
        requestSpec.accept(ContentType.JSON);
        requestSpec.pathParam("user-id", id );
        requestSpec.log().all();


        Response resp = requestSpec.get(endpoint);
        return resp;
    }
}
