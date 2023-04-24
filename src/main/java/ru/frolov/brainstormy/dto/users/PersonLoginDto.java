package ru.frolov.brainstormy.dto.users;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonLoginDto {
    private static final int MIN_SIZE_LOGIN = 3;
    private static final int MAX_SIZE_LOGIN = 32;
    private static final int MIN_SIZE_PASSWORD = 6;

    @NotEmpty
    @Size(min = MIN_SIZE_LOGIN, max = MAX_SIZE_LOGIN)
    private String login;

    @NotEmpty
    @Size(min = MIN_SIZE_PASSWORD)
    private String password;
}
