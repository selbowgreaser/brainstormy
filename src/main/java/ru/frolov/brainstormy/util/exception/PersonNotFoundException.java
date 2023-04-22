package ru.frolov.brainstormy.util.exception;

import lombok.Getter;

@Getter
public class PersonNotFoundException extends RuntimeException {

    private final Integer userId;

    public PersonNotFoundException(Integer userId) {
        this.userId = userId;
    }
}
