package ru.easm.api.asserts;

import io.qameta.allure.Step;
import ru.easm.api.model.api.register.response.ErrorResponse;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static ru.easm.api.constants.enums.DataEnums.EMPTY_MESSAGE;

public class BaseAsserts {

    public static String textIfFailedFieldInTest(String fieldName) {
        return String.format("check field: %s", fieldName);
    }

    @Step("Проверка данных ответа регистрации пользователя со всеми пустыми данными")
    public static void assertRegisterEmptyFields(ErrorResponse actualResponse) {
        assertSoftly(softAssertions -> {
            assertThat(actualResponse.getType())
                    .as(textIfFailedFieldInTest("type"))
                    .isEqualTo(false);
            assertThat(actualResponse.getMessage())
                    .as(textIfFailedFieldInTest("message"))
                    .endsWith(EMPTY_MESSAGE.getValue());
        });
    }
}