package ru.frolov.brainstormy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.frolov.brainstormy.service.EducationService;

import java.security.Principal;

@Controller
@RequestMapping("/education")
public class EducationController {

    private final EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping
    public String index(Principal principal, Model model) {

        model.addAttribute("selectedCourses", educationService.findCoursesByPrincipal(principal));

        return "education/index";
    }
}
