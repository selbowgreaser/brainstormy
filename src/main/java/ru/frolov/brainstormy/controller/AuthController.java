package ru.frolov.brainstormy.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.frolov.brainstormy.dto.PersonRegistrationDto;
import ru.frolov.brainstormy.model.Person;
import ru.frolov.brainstormy.service.RegistrationService;
import ru.frolov.brainstormy.util.exception.PersonNotFoundException;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthController(RegistrationService registrationService, ModelMapper modelMapper) {
        this.registrationService = registrationService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("personRegistrationDto") PersonRegistrationDto personRegistrationDto) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("personRegistrationDto") @Valid PersonRegistrationDto personRegistrationDto,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "auth/registration";
        }

        registrationService.register(convertToPerson(personRegistrationDto));

        return "redirect:/auth/login";
    }

    @ExceptionHandler(PersonNotFoundException.class)
    private String handlepersonNotFoundException(PersonNotFoundException personNotFoundException, Model model) {
        model.addAttribute("exception", personNotFoundException);

        return "person-not-found";
    }

    private Person convertToPerson(PersonRegistrationDto personRegistrationDto) {
        return modelMapper.map(personRegistrationDto, Person.class);
    }

    private PersonRegistrationDto convertToPersonRegistrationDto(Person person) {
        return modelMapper.map(person, PersonRegistrationDto.class);
    }
}
