package ru.frolov.brainstormy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.frolov.brainstormy.model.Course;
import ru.frolov.brainstormy.model.Person;

import java.security.Principal;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class EducationService {

    private final PrincipalService principalService;

    @Autowired
    public EducationService(PrincipalService principalService) {
        this.principalService = principalService;
    }

    public List<Course> findCoursesByPrincipal(Principal principal) {
        Person person = principalService.findByPrincipal(principal);
        return person.getSelectedCourses();
    }
}
