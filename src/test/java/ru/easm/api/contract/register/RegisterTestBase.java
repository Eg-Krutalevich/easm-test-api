package ru.easm.api.contract.register;

import io.qameta.allure.Step;
import org.testng.annotations.BeforeClass;
import ru.easm.api.clients.rest.services.register.RegisterService;
import ru.easm.api.model.api.register.response.ErrorResponse;
import ru.easm.api.model.api.register.response.RegisterResponse;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static ru.easm.api.asserts.BaseAsserts.textIfFailedFieldInTest;
import static ru.easm.api.constants.enums.DataEnums.*;

public class RegisterTestBase {

    protected static RegisterService registerService;

    @BeforeClass
    public static void before() {
        registerService = new RegisterService();
    }

    @Step("Проверка данных ответа регистрации пользователя с валидными данными")
    protected static void assertRegisterSuccess(RegisterResponse actualResponse) {
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(actualResponse.getType())
                    .as(textIfFailedFieldInTest("type"))
                    .isEqualTo(true);
            softAssertions.assertThat(actualResponse.getText())
                    .as(textIfFailedFieldInTest("text"))
                    .isEqualTo(TEXT_VALID_PHONE.getValue());
        });
    }

    @Step("Проверка данных ответа регистрации пользователя с невалидным номером телефона")
    protected static void assertRegisterUnSuccessPhone(ErrorResponse actualResponse) {
        assertSoftly(softAssertions -> {
            assertThat(actualResponse.getType())
                    .as(textIfFailedFieldInTest("type"))
                    .isEqualTo(false);
            assertThat(actualResponse.getPhoneNumber().getMessage())
                    .as(textIfFailedFieldInTest("phoneNumber.messge"))
                    .isEqualTo(TEXT_INVALID_PHONE.getValue());
        });
    }

    @Step("Проверка данных ответа регистрации пользователя с невалидным номером телефона")
    protected static void assertRegisterUnSuccessPassword(ErrorResponse actualResponse) {
        assertSoftly(softAssertions -> {
            assertThat(actualResponse.getType())
                    .as(textIfFailedFieldInTest("type"))
                    .isEqualTo(false);
            assertThat(actualResponse.getPassword().getMessage())
                    .as(textIfFailedFieldInTest("password.message"))
                    .isEqualTo(PASSWORD_MESSAGE.getValue());
            assertThat(actualResponse.getPasswordValidation().getMessage())
                    .as(textIfFailedFieldInTest("passwordValidation.message"))
                    .isEqualTo(PASSWORD_MESSAGE.getValue());
        });
    }
}
