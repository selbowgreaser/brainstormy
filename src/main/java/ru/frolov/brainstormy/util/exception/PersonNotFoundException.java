package ru.frolov.brainstormy.util.exception;

import lombok.Getter;

@Getter
public class PersonNotFoundException extends RuntimeException {

    private Integer userId;
    private String userLogin;

    public PersonNotFoundException(Integer userId) {
        super("User with id " + userId + "not found");
        this.userId = userId;
    }

    public PersonNotFoundException(String userLogin) {
        super("User with login " + userLogin + "not found");
        this.userLogin = userLogin;
    }
}
