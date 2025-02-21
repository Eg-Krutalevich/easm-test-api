package ru.easm.api.model.api.register.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private Boolean type;
    private String text;
    private String message;
    private Phone phoneNumber;
    private Login login;
    private UserName userName;
    private Password password;
    private PasswordValidation passwordValidation;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Phone {

        @JsonProperty("messge")
        private String message;
        private String value;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Login {

        private String message;
        private String value;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserName {

        private String message;
        private String value;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Password {

        private String message;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PasswordValidation {

        private String message;
    }
}
