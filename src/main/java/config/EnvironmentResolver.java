package config;

import TestDataManager.TestDataManager;
import org.example.auth.Pojo.AuthPojo;

import java.io.IOException;
import java.util.Properties;

public class EnvironmentResolver {

    private static TestDataManager tdm = new TestDataManager();

    public static void resolveTo(String envName) throws IOException {
        try {

            var config = Config.resolve(envName);

            new TestContext(config);

            tdm.init(config.getEnvURL());

            System.out.println(config.getEnvURL());
            System.out.println(config.getEnvName());
            System.out.println(config.getLogLevel());

            AuthPojo jwt = tdm.getLoggedUser();

            System.out.println("Token" + jwt.getAccessToken());
            tdm.getRequestContext().setBearer(jwt.getAccessToken());
            TestContext.setToken(jwt.getAccessToken());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
