package ru.frolov.brainstormy.util.exception;

import lombok.Getter;

@Getter
public class CourseNotFoundException extends RuntimeException {

    private final Integer courseId;

    public CourseNotFoundException(Integer courseId) {
        this.courseId = courseId;
    }
}
