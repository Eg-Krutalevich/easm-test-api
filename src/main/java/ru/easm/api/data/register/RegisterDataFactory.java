package ru.easm.api.data.register;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import ru.easm.api.model.api.register.request.RegisterRequest;
import ru.easm.api.utils.RandomUtils;

@Slf4j
public class RegisterDataFactory {

    static Faker faker = new Faker();

    @Step("Создание пользователя с валидными данными")
    public static RegisterRequest buildRegisterValidData() {
        String password = faker.internet().password(
                8, 30, true, true);

        return RegisterRequest.builder()
                .login(faker.internet().emailAddress())
                .password(password)
                .passwordValidation(password)
                .build();
    }

    @Step("Создание пользователя со всеми пустыми полями")
    public static RegisterRequest buildRegisterEmptyAllFields() {
        return RegisterRequest.builder()
                .userName("")
                .login("")
                .phoneNumber("")
                .password("")
                .passwordValidation("")
                .build();
    }

    @Step("Создание пользователя с номером телефона, который не начинается на 7 или 8")
    public static RegisterRequest buildRegisterInvalidPhone() {
        String password = faker.internet().password(
                8, 30, true, true);

        return RegisterRequest.builder()
                .login(faker.internet().emailAddress())
                .phoneNumber(RandomUtils.generateNumeric(11))
                .password(password)
                .passwordValidation(password)
                .build();
    }

    @Step("Создание пользователя с пустой электронной почтой")
    public static RegisterRequest buildRegisterEmptyEmail() {
        String password = faker.internet().password(
                8, 30, true, true);

        return RegisterRequest.builder()
                .login("")
                .password(password)
                .passwordValidation(password)
                .build();
    }

    @Step("Создание пользователя с паролем подтверждения который не совпадает с паролем")
    public static RegisterRequest buildRegisterInvalidPasswordValidation() {
        String password = faker.internet().password(
                8, 32, true, true);

        return RegisterRequest.builder()
                .login(faker.internet().emailAddress())
                .password(password)
                .passwordValidation(password + "!")
                .build();
    }

}