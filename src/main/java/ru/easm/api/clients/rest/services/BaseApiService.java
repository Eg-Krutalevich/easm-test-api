package ru.easm.api.clients.rest.services;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import ru.easm.api.clients.rest.specs.BaseApiSpecs;

import static io.qameta.allure.Allure.addAttachment;
import static ru.easm.api.utils.JsonUtils.writeObjectAsString;

public class BaseApiService {

    protected final BaseApiSpecs baseApiSpecs = new BaseApiSpecs();

    public void setBody(Object requestObject) {
        baseApiSpecs.setBody(writeObjectAsString(requestObject));
        addAttachment("Body", writeObjectAsString(requestObject));
    }

    public void initService(String baseURI) {
        baseApiSpecs.initializeRequestResponseObjects();
        baseApiSpecs.setBaseURI(baseURI);
        baseApiSpecs.addFilters(
                new RequestLoggingFilter(),
                new ResponseLoggingFilter(),
                new AllureRestAssured()
        );
        baseApiSpecs.setContentType(ContentType.JSON);
    }
}