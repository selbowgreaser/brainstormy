package ru.frolov.brainstormy.util.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundException extends RuntimeException {

    private Integer userId;

    public UserNotFoundException(Integer userId) {
        this.userId = userId;
    }
}
