import java.io.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws IOException {
//        EnvironmentResolver.resolveTo();
        WaitContext.execute(WaitType.API, 200);
    }
}

class WaitContext {

    public static void execute(WaitType type, int duration) {
        WaitStrategy strategy = WaitStrategyFactory.createStrategy(type);
        strategy.waitFor(duration);
    }
}

enum WaitType {
    ELEMENT,
    PAGE_LOAD,
    API
}

@FunctionalInterface
interface WaitStrategy {
    void waitFor(int duration);
}


class WaitForElement implements WaitStrategy {
    @Override
    public void waitFor(int duration) {
        System.out.println("Waiting for element..." + duration + "...seconds");
        try {
            Thread.sleep(duration * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class WaitForApiResponse implements WaitStrategy {
    @Override
    public void waitFor(int duration) {
        System.out.println("Waiting for API response for " + duration + " seconds...");
        try {
            Thread.sleep(duration * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Strategie 3: Wait pentru animații UI
class WaitForAnimation implements WaitStrategy {
    @Override
    public void waitFor(int duration) {
        System.out.println("Waiting for animation to finish for " + duration + " seconds...");
        try {
            Thread.sleep(duration * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


class WaitStrategyFactory {

    public static WaitStrategy createStrategy(WaitType type) {
        switch (type) {
            case ELEMENT:
                return new WaitForElement();
            case PAGE_LOAD:
                return new WaitForAnimation();
            case API:
                return new WaitForApiResponse();
            default:
                throw new IllegalArgumentException("Unknown wait type: " + type);
        }
    }
}