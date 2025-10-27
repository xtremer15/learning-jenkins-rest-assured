package TestDataManager;

import com.fasterxml.jackson.databind.JsonNode;
import config.ConfigLoader;
import config.Routes;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import org.example.auth.Pojo.AuthPojo;
import org.example.auth.Service.AuthService;
import utils.BaseService;
import utils.RequestContext;
import utils.ResourecesJsonRead;

import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class TestDataManager {
    private ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<>();


    RequestContext requestContext = new RequestContext();
    private AuthService authSvc = new AuthService(Routes.login);

    public void init(String url) {
        requestContext.init(url);
        requestContext.addHeader("Content-type", "application/json");
    }


    public static boolean isFeatureEnabled(String envName) {
        String isFeatureEnabled;
        try {
            Properties env = ConfigLoader.loadEnv(envName);
            isFeatureEnabled = env.getProperty("flag");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Feature is :" + isFeatureEnabled);
        return Boolean.parseBoolean(isFeatureEnabled);
    }


    public void setCache(String key, String value) {
        if (!cache.containsKey(key)) {
            cache.put(key, value);
        } else {
            throw new Error("Key " + cache.get(key) + " already present");
        }
    }


    public void setBearer(String jwt) {
        requestContext.setBearer(jwt);
    }

    public AuthPojo getLoggedUser() {
        JsonNode loginCredentials = ResourecesJsonRead.getLoginCredentials();
        return authSvc.login(loginCredentials);
    }

    public RequestContext getRequestContext() {
        return requestContext;
    }


    public void createUser() {
        Object payload = DataSeeder.seedUser();
    }

    public JsonNode getAuthCreds() {
        return ResourecesJsonRead.getLoginCredentials();
    }
}
