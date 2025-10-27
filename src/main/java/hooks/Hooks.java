package hooks;

import config.EnvironmentResolver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

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
}
