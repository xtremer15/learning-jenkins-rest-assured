package config;

import enums.EnvFilePaths;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static Properties props = new Properties();

    private static InputStream load(String pathToFile) throws IOException {
        System.out.println(pathToFile);
        return ConfigLoader.class.getClassLoader().getResourceAsStream(pathToFile);

    }

    public static Properties loadEnv(String env) throws IOException {
        switch (env.toLowerCase()) {
            case "dev":
                props.load(ConfigLoader.load(EnvFilePaths.DEV.getFilePath()));
                break;
            case "qa":
                props.load(ConfigLoader.load(EnvFilePaths.QA.getFilePath()));
                break;
        }
        return props;
    }
}
