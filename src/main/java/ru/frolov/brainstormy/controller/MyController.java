package ru.frolov.brainstormy.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.frolov.brainstormy.dto.StudentProfileDto;
import ru.frolov.brainstormy.model.Person;
import ru.frolov.brainstormy.model.Role;
import ru.frolov.brainstormy.service.MyService;
import ru.frolov.brainstormy.service.PersonService;

import java.security.Principal;

@Controller
@RequestMapping("/my")
public class MyController {

    private final MyService myService;
    private final PersonService personService;
    private final ModelMapper modelMapper;

    @Autowired
    public MyController(MyService myService, PersonService personService, ModelMapper modelMapper) {
        this.myService = myService;
        this.personService = personService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/profile")
    public String showProfile(Principal principal, Model model) {
        String login = principal.getName();

        Person person = myService.findByLogin(login);

        Role role = personService.getRoleById(person.getId());

        if (role.equals(Role.STUDENT)) {
            model.addAttribute("studentProfileDto", convertPersonToStudentProfileDto(person));
            return "my/student-profile";
        }
        return null;
    }

    private StudentProfileDto convertPersonToStudentProfileDto(Person person) {
        return modelMapper.map(person, StudentProfileDto.class);
    }
}
