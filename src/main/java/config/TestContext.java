package config;

public class TestContext {
    public static String getEnvName() {
        return envName;
    }

    public static void setEnvName(String envName) {
        TestContext.envName = envName;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static void setBaseUrl(String baseUrl) {
        TestContext.baseUrl = baseUrl;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        TestContext.token = token;
    }

    public static String getUuid() {
        return uuid;
    }

    public static void setUuid(String uuid) {
        TestContext.uuid = uuid;
    }

    public static int getTestDuration() {
        return testDuration;
    }

    public static void setTestDuration(int testDuration) {
        TestContext.testDuration = testDuration;
    }

    public static String getSeedId() {
        return seedId;
    }

    public static void setSeedId(String seedId) {
        TestContext.seedId = seedId;
    }

    public static String getTestStatus() {
        return testStatus;
    }

    public static void setTestStatus(String testStatus) {
        TestContext.testStatus = testStatus;
    }

    public static String envName;
    public static String baseUrl;
    public static String token;
    public static String uuid;
    public static int testDuration;
    public static String seedId;
    public static String testStatus;
}
