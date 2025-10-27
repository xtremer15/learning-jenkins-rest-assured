package config;

import TestDataManager.TestDataManager;
import org.example.auth.Pojo.AuthPojo;

import java.io.IOException;
import java.util.Properties;

public class EnvironmentResolver {

    private static TestDataManager tdm = new TestDataManager();

    public static void resolveTo(String envName) throws IOException {
        try {
            Properties env = ConfigLoader.loadEnv(envName);

            TestContext.setBaseUrl(env.getProperty("url"));
            TestContext.setEnvName(env.getProperty("envenv_name"));

            tdm.init(env.getProperty("url"));

            AuthPojo jwt = tdm.getLoggedUser();
            System.out.println(jwt.getAccessToken());
//            tdm.getRequestContext().setBearer(jwt.getAccessToken());
//            TestContext.setToken(jwt.getAccessToken());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
