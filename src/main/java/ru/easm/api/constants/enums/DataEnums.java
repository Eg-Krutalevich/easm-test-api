package ru.easm.api.constants.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DataEnums {

    TEXT_VALID_PHONE("Сейчас на ваш телефон поступит звонок или сообщение, последние 4 цифры являются кодом"),
    TEXT_INVALID_PHONE("Введите номер телефона в таком формате: 79991112233 или 89991112233. Он должен начинаться с 7 или 8 и не содержать других символов кроме цифр"),
    EMPTY_MESSAGE("не может быть пустым"),
    PASSWORD_MESSAGE("Пароли которые вы ввели не совпадают");

    private final String value;

}