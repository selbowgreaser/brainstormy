package ru.frolov.brainstormy.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.frolov.brainstormy.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class StudentProfileDto {
    private static final String BIRTHDAY_FORMAT = "dd.MM.yyyy";
    private static final String BIRTHDAY_ERROR_MESSAGE = "Дата рождения не должна быть в будущем";
    private static final int MIN_SIZE_LOGIN = 3;
    private static final int MAX_SIZE_LOGIN = 32;

    @NotEmpty
    @Size(min = MIN_SIZE_LOGIN, max = MAX_SIZE_LOGIN)
    private String login;

    @NotEmpty
    private String surname;

    @NotEmpty
    private String name;

    private String patronymic;

    @Email
    private String email;

    private String phone;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = BIRTHDAY_FORMAT)
    @NotNull
    @Past(message = BIRTHDAY_ERROR_MESSAGE)
    private LocalDate birthday;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    private Student student;

    private List<Course> selectedCourses;

    private List<Course> createdCourses;
}
