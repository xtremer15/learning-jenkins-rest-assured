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
            EnvironmentResolver.resolveTo();
        } catch (IOException e) {
            throw new RuntimeException("Failed to resolve environment", e);
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("✅ Suite finished");
    }

}
