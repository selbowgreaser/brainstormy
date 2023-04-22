package ru.frolov.brainstormy.util.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.frolov.brainstormy.model.Person;
import ru.frolov.brainstormy.service.PersonService;

@Component
public class PersonValidator implements Validator {

    private final PersonService personService;

    @Autowired
    public PersonValidator(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        Person person = (Person) target;

        if (personService.isLoginExist(person.getLogin())) {
            errors.rejectValue("login", "", "Человек с таким именем пользователя уже существует!");
        } else if (personService.isEmailExist(person.getEmail())) {
            errors.rejectValue("email", "", "Человек с такой электронной почтой уже существует!");
        } else if (personService.isPhoneExist(person.getPhone())) {
            errors.rejectValue("phone", "", "Человек с таким номером телефона уже существует!");
        }
    }
}
