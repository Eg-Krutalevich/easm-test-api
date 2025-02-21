package ru.easm.api.constants.enums.endpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RegisterEndpoints {

    REGISTER("/calluserforsignup");

    private final String path;

}