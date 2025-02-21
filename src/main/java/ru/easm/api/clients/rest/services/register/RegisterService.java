package ru.easm.api.clients.rest.services.register;

import io.qameta.allure.Step;
import ru.easm.api.clients.rest.services.BaseApiService;

import static io.restassured.http.Method.POST;
import static ru.easm.api.constants.BaseUri.BASE_URI;
import static ru.easm.api.constants.enums.endpoints.RegisterEndpoints.REGISTER;

public class RegisterService extends BaseApiService {

    public void initRegisterService() {
        initService(BASE_URI);
    }

    @Step("Зарегистрировать пользователя")
    public <T> T register(Object registerRequest,
                          int statusCode,
                          Class<T>clazz) {
        initRegisterService();
        setBody(registerRequest);
        return baseApiSpecs.sendRequestAndGetResponse(POST, REGISTER.getPath(), statusCode)
                .as(clazz);
    }
}