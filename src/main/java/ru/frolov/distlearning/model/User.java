package ru.frolov.distlearning.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    private static final String BIRTHDAY_FORMAT = "dd.MM.yyyy";
    private static final String BIRTHDAY_ERROR_MESSAGE = "Дата рождения не должна быть в будущем";
    private static final int MIN_SIZE_LOGIN = 3;
    private static final int MAX_SIZE_LOGIN = 32;
    private static final int MIN_SIZE_PASSWORD = 6;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "login")
    @NotEmpty
    @Size(min = MIN_SIZE_LOGIN, max = MAX_SIZE_LOGIN)
    private String login;

    @Column(name = "password")
    @NotEmpty
    @Size(min = MIN_SIZE_PASSWORD)
    private String password;

    @Column(name = "surname")
    @NotEmpty
    private String surname;

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "phone")
    private Integer phone;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = BIRTHDAY_FORMAT)
    @Column(name = "birthday")
    @NotNull
    @Past(message = BIRTHDAY_ERROR_MESSAGE)
    private LocalDate birthday;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "user")
    private Student student;

    @OneToOne(mappedBy = "user")
    private Teacher teacher;

    @OneToOne(mappedBy = "user")
    private Admin admin;

    @ManyToMany(mappedBy = "users")
    private List<Authority> authorities;

    @ManyToMany(mappedBy = "students")
    private List<Course> selectedCourses;

    @ManyToMany(mappedBy = "authors")
    private List<Course> createdCourses;
}
