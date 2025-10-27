package auth;


import TestDataManager.TestDataManager;
import com.fasterxml.jackson.databind.JsonNode;
import config.Routes;
import hooks.Hooks;
import io.restassured.RestAssured;
import org.example.auth.Pojo.AuthPojo;
import org.example.auth.Service.AuthService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;

@Listeners({hooks.Hooks.class})
public class POSTLoginTest  {
    AuthService authService;
    TestDataManager tdm;

    @BeforeTest
    public void setup() {
        authService = new AuthService(Routes.login);
        tdm = new TestDataManager();
    }

    @Test(groups = {"smoke"})
    public void logUserAndGetEmail() {

        AuthPojo resp = authService.login(tdm.getAuthCreds());
        Assert.assertEquals(resp.getId(), 1);
        Assert.assertEquals(resp.getEmail(), "emily.johnson@x.dummyjson.com");
    }

    @Test(groups = {"smoke", "regression"})
    public void logUserAndGetIdANdEmail() {
        AuthPojo resp = authService.loginUser("emilys", "emilyspass", 20);
        Assert.assertEquals(resp.getId(), 1);
        Assert.assertEquals(resp.getEmail(), "emily.johnson@x.dummyjson.com");
    }

    @Test(groups = {"regression"})
    public void logUserAndGetName() {
        AuthPojo resp = authService.loginUser("emilys", "emilyspass", 20);
        Assert.assertEquals(resp.getFirstName(), getRandomName());
    }


    public static String getRandomName() {
        final String[] names = {"asdad", "Emily"};

        Random random = new Random();
        return names[random.nextInt(names.length)];
    }
}
