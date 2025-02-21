package ru.easm.api.contract.register;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import org.testng.annotations.Test;
import ru.easm.api.model.api.register.request.RegisterRequest;
import ru.easm.api.model.api.register.response.ErrorResponse;

import static org.apache.http.HttpStatus.SC_OK;
import static ru.easm.api.asserts.BaseAsserts.assertRegisterEmptyFields;
import static ru.easm.api.constants.changeless.TestSuiteTags.CONTRACT;
import static ru.easm.api.constants.changeless.TestSuiteTags.NEGATIVE;
import static ru.easm.api.data.register.RegisterDataFactory.*;

@Epic("EASM тестовое задание (API)")
@Feature("Функциональность регистрации")
@Story("Регистрация пользователя")
@Tags({@Tag(CONTRACT), @Tag(NEGATIVE)})
public class RegisterNegativeTest extends RegisterTestBase {

    @Test(description = "Проверка регистрации пользователя со всеми пустыми данными")
    public void registerEmptyFieldsTest() {
        RegisterRequest registerRequest = buildRegisterEmptyAllFields();
        ErrorResponse registerResponse = registerService.register(
                registerRequest,
                SC_OK,
                ErrorResponse.class
        );
        assertRegisterEmptyFields(registerResponse);
    }

    @Test(description = "Проверка регистрации пользователя с невалидным номером телефона")
    public void registerInvalidPhoneTest() {
        RegisterRequest registerRequest = buildRegisterInvalidPhone();
        ErrorResponse registerResponse = registerService.register(
                registerRequest,
                SC_OK,
                ErrorResponse.class
        );
        assertRegisterUnSuccessPhone(registerResponse);
    }

    @Test(description = "Проверка регистрации пользователя с пустой электронной почтой")
    public void registerEmptyEmailTest() {
        RegisterRequest registerRequest = buildRegisterEmptyEmail();
        ErrorResponse registerResponse = registerService.register(
                registerRequest,
                SC_OK,
                ErrorResponse.class
        );
        assertRegisterEmptyFields(registerResponse);
    }

    @Test(description = "Проверка регистрации пользователя с паролем подтверждения, который не совпадает" +
            "с паролем и длиной меньше 8 символов")
    public void registerInvalidPasswordValidationTest() {
        RegisterRequest registerRequest = buildRegisterInvalidPasswordValidation();
        ErrorResponse registerResponse = registerService.register(
                registerRequest,
                SC_OK,
                ErrorResponse.class
        );
        assertRegisterUnSuccessPassword(registerResponse);
    }
}