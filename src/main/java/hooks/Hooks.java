package hooks;

import config.EnvironmentResolver;
import config.TestContext;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.annotations.*;

import java.io.IOException;

public class Hooks implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        System.out.println("🚀 Suite start — resolving environment...");
        try {
            EnvironmentResolver.resolveTo("dev");
        } catch (IOException e) {
            throw new RuntimeException("Failed to resolve environment", e);
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("✅ Suite finished");
    }

    @BeforeMethod
    public void setup() {
        TestContext.get().setSeedId("abc123"); // thread-ul tău, instanța ta
    }

    @AfterMethod
    public void teardown() {
        String status = TestContext.get().getTestStatus(); // tot instanța ta
        TestContext.clear(); // curăță după test, important
    }
}
