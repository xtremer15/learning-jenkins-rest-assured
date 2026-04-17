import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import config.EnvironmentResolver;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        EnvironmentResolver.resolveTo("qa");
    }
}

//
//class ConfigLoader {
//    private static volatile JsonObject instance = null;
//    private static final String FILE_PATH = "src/main/resources/config.json";
//
//    private ConfigLoader() {
//    }
//
//    public static JsonObject readFile() throws IOException {
//        if (instance == null) {
//            synchronized (ConfigLoader.class) {
//                if (instance == null) {
//                    InputStream rawFile = Files.newInputStream(Paths.get(FILE_PATH));
//                    String file = new BufferedReader(new InputStreamReader(rawFile)).lines().collect(Collectors.joining("\n"));
//                    instance = JsonParser.parseString(file).getAsJsonObject();
//                    ;
//                }
//            }
//        }
//        return instance;
//    }
//
//    public static JsonElement getKey(String key) {
//        if (instance == null) throw new IllegalStateException("Config not loaded");
//        return instance.get(key);
//    }
//}
//
//enum RequestMethod {
//    POST("POST"),
//    PUT("PUT"),
//    PATCH("PATCH"),
//    GET("GET"),
//    DELETE("DELETE");
//
//    private final String requestMethod;
//
//    RequestMethod(String method) {
//        this.requestMethod = method;
//    }
//
//    public String getRequestMethod() {
//        return requestMethod;
//    }
//}
//
//class ApiRequest {
//    private String url;
//    private RequestMethod method;
//
//    public ApiRequest(Builder builder) {
//        this.url = builder.url;
//        this.method = builder.method;
//    }
//
//    static class Builder {
//        private String url;
//        private RequestMethod method;
//        private HashMap<String, String> headers;
//        private HashMap<String, String> queryParams;
//        private String requestBOdy;
//
//        public Builder setUrl(String url) {
//            this.url = url;
//            return this;
//        }
//
//        public Builder setRequestMethod(RequestMethod method) {
//            this.method = method;
//            return this;
//        }
//
//        public Builder setHeaders(String headerKey, String headerValue) {
//            this.headers.put(headerKey, headerValue);
//            return this;
//        }
//
//        public Builder setQueryParams(String key, String value) {
//            this.queryParams.put(key, value);
//            return this;
//        }
//
//        public final ApiRequest build() {
//            if (this.url.isEmpty() || this.method.getRequestMethod().isEmpty()) {
//                throw new IllegalStateException("URL and Request method are missing");
//            }
//            return new ApiRequest(this);
//        }
//
//        public Builder execute() throws URISyntaxException {
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(new URI(this.url))
//                    .version(HttpClient.Version.HTTP_2)
//                    .build();
//
//            String resp = HttpClient.newHttpClient()
//                    .sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                    .thenApply(HttpResponse::body)
//                    .join();
//            JsonObject obj = JsonParser.parseString(resp).getAsJsonObject();
//            return this;
//        }
//
//    }
//
//}