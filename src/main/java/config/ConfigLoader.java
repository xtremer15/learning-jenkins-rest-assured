package config;

import enums.EnvFilePaths;
import utils.file_utils.FactoryFileLoader;
import utils.file_utils.JsonFileLoader;
import utils.file_utils.PropertiesFileReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static volatile Properties instance;

    private ConfigLoader() {
    }

    public static Properties getInstance(String env) {
        if (instance == null) {
            synchronized (ConfigLoader.class) {
                if (instance == null) {
                    instance = (Properties) FactoryFileLoader.getReader("properties", env);

                }
            }
        }
        return instance;
    }
}
