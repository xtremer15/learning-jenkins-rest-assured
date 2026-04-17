package config;

import enums.EnvFilePaths;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

@Setter
@Getter
@Builder
public class Config {
    private String envURL = "";
    private String envName = "";
    private String DBConnectionString = "";
    private double portNr = 0;
    private HashMap<String, String> featureFlags = new HashMap<String, String>();
    private String logLevel = "";
    @Builder.Default
    private double timeout = 30;


    public static Config resolve(String envName) throws IOException {
        return Config.builder()
                .envURL(getConfig("BASE_URL", envName))
                .logLevel(getConfig("LOG_LEVEL", envName))
                .timeout(Integer.parseInt(getConfig("TIMEOUT", envName)))
                .envName(getConfig("ENV_NAME", envName))
                .build();
    }

    private static String getConfig(String key, String envName) {
        Properties env = ConfigLoader.getInstance(envName);
        String valueFromEnv = System.getenv(envName);
        if (valueFromEnv != null) {
            return valueFromEnv;
        }
        return env.getProperty(key);
    }
}
