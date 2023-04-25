package ru.frolov.brainstormy.dto.courses;

import lombok.Getter;
import lombok.Setter;
import ru.frolov.brainstormy.model.Person;

import java.util.List;

@Setter
@Getter
public class CourseIndexDto {

    private String title;

    private List<Person> authors;
}
