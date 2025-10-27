package org.example.auth.Service;

import com.fasterxml.jackson.databind.JsonNode;
import config.Routes;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.auth.Pojo.AuthPojo;
import utils.ResourecesJsonRead;
import utils.BaseService;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

public class AuthService extends BaseService {
    private String basePath;

    public AuthService(String authSvcPath){
        basePath = authSvcPath;
    }

    public AuthPojo loginUser(String userName, String password, int expiresInMins) {
        JsonNode loginCredentials = ResourecesJsonRead.getLoginCredentials();
        Response response = given()
                .contentType(ContentType.JSON)
                .body(loginCredentials)
                .filter(new RequestLoggingFilter())  // Logs formatted request
                .filter(new ResponseLoggingFilter())  // Logs formatted request
                .post()
                .then()
                .extract().response();

        return response.body().as(AuthPojo.class);
    }

    public AuthPojo login(Object loginCreds){
        return post(loginCreds, basePath).as(AuthPojo.class);
    }
}
