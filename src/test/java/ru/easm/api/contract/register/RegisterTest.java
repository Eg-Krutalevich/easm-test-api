package ru.easm.api.contract.register;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import org.testng.annotations.Test;
import ru.easm.api.model.api.register.request.RegisterRequest;
import ru.easm.api.model.api.register.response.RegisterResponse;

import static org.apache.http.HttpStatus.SC_OK;
import static ru.easm.api.constants.changeless.TestSuiteTags.CONTRACT;
import static ru.easm.api.constants.changeless.TestSuiteTags.POSITIVE;
import static ru.easm.api.data.register.RegisterDataFactory.buildRegisterValidData;

@Epic("EASM тестовое задание (API)")
@Feature("Функциональность регистрации")
@Story("Регистрация пользователя")
@Tags({@Tag(CONTRACT), @Tag(POSITIVE)})
public class RegisterTest extends RegisterTestBase {

    @Test(description = "Проверка регистрации пользователя с валидными данными")
    public void registerSuccessTest() {
        RegisterRequest registerRequest = buildRegisterValidData();
        RegisterResponse registerResponse = registerService.register(
                registerRequest,
                SC_OK,
                RegisterResponse.class
        );
        assertRegisterSuccess(registerResponse);
    }
}