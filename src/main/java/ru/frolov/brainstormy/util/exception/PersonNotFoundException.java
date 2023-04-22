package ru.frolov.brainstormy.util.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonNotFoundException extends RuntimeException {

    private Integer userId;

    public PersonNotFoundException(Integer userId) {
        this.userId = userId;
    }
}
