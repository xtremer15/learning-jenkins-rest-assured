package auth;


import io.restassured.RestAssured;
import org.example.auth.Service.AuthService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

public class POSTLoginTest {
    AuthService authService;
    @BeforeTest
    public void setup(){
        RestAssured.baseURI = "https://dummyjson.com/auth/login";
        authService    = new AuthService();
    }


    @Test
    public void logUserAndGetIdANdEmail(){
        var resp =   authService.loginUser("emilys","emilyspass",20);
        Assert.assertEquals(resp.getId(), 1);
        Assert.assertEquals(resp.getEmail(), "emily.johnson@x.dummyjson.com");
    }

    @Test
    public void logUserAndGetName(){
        var resp =   authService.loginUser("emilys","emilyspass",20);
        Assert.assertEquals(resp.getFirstName(), getRandomName());
    }


    public static String getRandomName() {
        final String[] names = {"asdad", "Emily"};

        Random random = new Random();
        return names[random.nextInt(names.length)];
    }
}
