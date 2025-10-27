package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.response.Response.*;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.given;

public class BaseService {


    public Response post(Object body, String basePath) {
        System.out.println("================");
        return given()
                .spec(RequestContext.get())
                .body(body)
                .post(basePath)
                .then().log().all().and()
                .extract().response();
    }

    public Response patch(Object body, String basePath) {
        return given()
                .spec(RequestContext.get())
                .body(body)
                .when()
                .patch(basePath)
                .then()
                .log().all()
                .extract().response();
    }


}
