package ru.frolov.brainstormy.util.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.frolov.brainstormy.model.User;
import ru.frolov.brainstormy.service.UserService;

@Component
public class UserValidator implements Validator {

    private final UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        User user = (User) target;

        if (userService.isLoginExist(user.getLogin())) {
            errors.rejectValue("login", "", "Человек с таким именем пользователя уже существует!");
        } else if (userService.isEmailExist(user.getEmail())) {
            errors.rejectValue("email", "", "Человек с такой электронной почтой уже существует!");
        } else if (userService.isPhoneExist(user.getPhone())) {
            errors.rejectValue("phone", "", "Человек с таким номером телефона уже существует!");
        }
    }
}
