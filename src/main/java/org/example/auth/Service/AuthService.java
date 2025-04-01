package org.example.auth.Service;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.example.auth.Pojo.AuthPojo;
import org.example.utils.ResourecesJsonRead;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthService {
    RequestSpecBuilder requestSpecBuilder ;
    public AuthPojo loginUser(String userName, String password, int expiresInMins){
        var loginCredentials = ResourecesJsonRead.getLoginCredentials();
        return given()
                .contentType(ContentType.JSON).log().all()
                .body(loginCredentials)
                .post()
                .then()
                .extract().response().body().as(AuthPojo.class);
    }
}
