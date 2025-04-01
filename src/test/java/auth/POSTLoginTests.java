package auth;


import io.restassured.RestAssured;
import org.example.auth.Service.AuthService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class POSTLoginTests {
    AuthService authService;
    @BeforeTest
    public void setup(){
        RestAssured.baseURI = "https://dummyjson.com/auth/login";
        authService    = new AuthService();
    }


    @Test
    public void logUserAndGetToken(){
        var resp =   authService.loginUser("emilys","emilyspass",20);
        System.out.println(resp.getAccessToken());
    }
}
