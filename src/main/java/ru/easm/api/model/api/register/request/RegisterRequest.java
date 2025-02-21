package ru.easm.api.model.api.register.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {

    @Builder.Default
    private String userName = "Liza";
    private String login;
    @Builder.Default
    private String phoneNumber = "79091086630";
    private String password;
    private String passwordValidation;

}