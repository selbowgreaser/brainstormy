package ru.frolov.brainstormy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.frolov.brainstormy.model.Person;
import ru.frolov.brainstormy.repository.UserRepository;

@Service
@Transactional(readOnly = true)
public class MyService {

    private final UserRepository userRepository;

    @Autowired
    public MyService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Person findByLogin(String login) {
        return userRepository.findByLogin(login).get();
    }

}
