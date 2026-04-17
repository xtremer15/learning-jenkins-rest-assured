package config;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class TestContext {

    @Getter
    @Setter
    public static String envName;
    @Getter
    @Setter
    public static String baseUrl;
    @Getter
    @Setter
    public static String token;
    @Getter
    @Setter
    public static String uuid;
    @Getter
    @Setter
    public static int testDuration;
    @Getter
    @Setter
    public static String seedId;
    @Getter
    @Setter
    public static String testStatus;

    public TestContext(Config config) {
        TestContext.envName = config.getEnvName();
        TestContext.baseUrl = config.getEnvURL();
    }

    // --- Annotation Cache Logic ---
    private static final Map<String, Object> payloadCache = new ConcurrentHashMap<>();

    public static <T> T getPayload(Class<T> clazz) {
        Object val = payloadCache.get(clazz.getName());
        if (val != null) {
            return clazz.cast(val);
        }
        return null;
    }

    public static void setPayload(Class<?> clazz, Object payload) {
        payloadCache.put(clazz.getName(), payload);
    }

    public static void clearPayloadCache() {
        payloadCache.clear();
    }
    // ------------------------------


}
