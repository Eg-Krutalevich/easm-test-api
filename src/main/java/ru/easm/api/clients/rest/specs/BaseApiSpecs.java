package ru.easm.api.clients.rest.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseApiSpecs {

    private RequestSpecification requestSpecification;

    public void initializeRequestResponseObjects() {
        requestSpecification = new RequestSpecBuilder()
                .setAccept(ContentType.ANY)
                .build();
    }

    public void setBaseURI(String baseURI) {
        requestSpecification.baseUri(baseURI);
    }

    public void addFilters(Filter filter, Filter... filter2) {
        requestSpecification.filters(filter, filter2);
    }

    public void addHeader(String header, String value) {
        requestSpecification.header(header, value);
    }

    public void addHeaders(Map<String, String> headers) {
        requestSpecification.headers(headers);
    }

    public void setContentType(ContentType contentType) {
        requestSpecification.contentType(contentType);
    }

    public void setBody(String requestParams) {
        requestSpecification.body(requestParams);
    }

    public Response sendRequestAndGetResponse(Method method,
                                              String endpoint,
                                              int statusCode) {
        Response response = given()
                .spec(requestSpecification)
                .relaxedHTTPSValidation()
                .request(method, endpoint)
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .response();
        reset();
        return response;
    }

    private void reset() {
        requestSpecification.body("");
    }
}