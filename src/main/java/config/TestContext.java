package config;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class TestContext {
    private TestContext() {
    }

    @Getter
    @Setter
    public static String envName;
    @Getter
    @Setter
    public static String baseUrl;
    @Getter
    @Setter
    public static String token;

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
