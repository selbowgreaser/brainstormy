package ru.frolov.brainstormy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.frolov.brainstormy.model.User;
import ru.frolov.brainstormy.repository.UserRepository;
import ru.frolov.brainstormy.util.exception.UserNotFoundException;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public Boolean isLoginExist(String login) {
        return userRepository.findByLogin(login).isPresent();
    }

    public Boolean isEmailExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public Boolean isPhoneExist(Integer phone) {
        return userRepository.findByPhone(phone).isPresent();
    }

}
