import config.EnvironmentResolver;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        EnvironmentResolver.resolveTo("dev");
    }
}
