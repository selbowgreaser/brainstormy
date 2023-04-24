package ru.frolov.brainstormy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.frolov.brainstormy.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
