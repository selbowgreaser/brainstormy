package ru.frolov.brainstormy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.frolov.brainstormy.model.Person;
import ru.frolov.brainstormy.service.PrincipalService;

import java.security.Principal;

@Controller
@RequestMapping("/course-management")
public class CourseManagementController {

    private final PrincipalService principalService;

    @Autowired
    public CourseManagementController(PrincipalService principalService) {
        this.principalService = principalService;
    }

    @GetMapping
    public String index(Principal principal, Model model) {
        Person person = principalService.findByPrincipal(principal);

        model.addAttribute("createdCourses", person.getCreatedCourses());

        return "course-management/index";
    }
}
