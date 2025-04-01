package org.example.auth.Service;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.auth.Pojo.AuthPojo;
import org.example.utils.ResourecesJsonRead;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthService {
    RequestSpecBuilder requestSpecBuilder;

    public AuthPojo loginUser(String userName, String password, int expiresInMins) {
        var loginCredentials = ResourecesJsonRead.getLoginCredentials();
        Response response = given()
                .contentType(ContentType.JSON)
                .body(loginCredentials)
                .filter(new RequestLoggingFilter())  // Logs formatted request
                .post()
                .then()
                .extract().response();

// Pretty print the response body before deserializing
        System.out.println("Response Body:\n" + response.prettyPeek());

        return response.body().as(AuthPojo.class);
    }
}
