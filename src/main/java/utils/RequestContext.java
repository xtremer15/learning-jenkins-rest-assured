package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestContext {

    private static RequestSpecification requestSpec;

    public RequestContext() {
    }

    public void init(String baseUri) {
        if (requestSpec == null) {
            requestSpec = new RequestSpecBuilder()
                    .setBaseUri(baseUri)
                    .setContentType(ContentType.JSON)
                    .log(LogDetail.ALL)
                    .build();
            System.out.println("✅ RequestContext initialized with baseUri: " + baseUri);
        }
    }

    public static RequestSpecification get() {
        if (requestSpec == null)
            throw new IllegalStateException("❌ RequestContext not initialized. Call RequestContext.init(baseUri) first.");
        return requestSpec;
    }

    public void addHeader(String key, String value) {
        requestSpec.header(key, value);
    }

    public void reset() {
        requestSpec = null;
    }

    public void setBearer(String jwt) {
        System.out.println("Called setBearer");
        requestSpec.header("Authorization", "Bearer " + jwt);
    }

    public void setContentType(ContentType contentType) {
        requestSpec.contentType(contentType);
    }

    public void setParam(String key, String value) {
        requestSpec.param(key, value);
    }

}