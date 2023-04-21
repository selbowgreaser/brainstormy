package ru.frolov.brainstormy.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class UserRegistrationDto {

    private static final String BIRTHDAY_FORMAT = "dd.MM.yyyy";
    private static final String BIRTHDAY_ERROR_MESSAGE = "Дата рождения не должна быть в будущем";
    private static final int MIN_SIZE_LOGIN = 3;
    private static final int MAX_SIZE_LOGIN = 32;
    private static final int MIN_SIZE_PASSWORD = 6;

    @NotEmpty
    @Size(min = MIN_SIZE_LOGIN, max = MAX_SIZE_LOGIN)
    private String login;

    @NotEmpty
    @Size(min = MIN_SIZE_PASSWORD)
    private String password;

    @NotEmpty
    private String surname;

    @NotEmpty
    private String name;

    private String patronymic;

    @Email
    private String email;

    private Integer phone;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = BIRTHDAY_FORMAT)
    @NotNull
    @Past(message = BIRTHDAY_ERROR_MESSAGE)
    private LocalDate birthday;
}
