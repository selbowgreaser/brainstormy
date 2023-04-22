package ru.frolov.brainstormy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.frolov.brainstormy.model.Person;
import ru.frolov.brainstormy.model.Role;
import ru.frolov.brainstormy.repository.UserRepository;
import ru.frolov.brainstormy.util.exception.PersonNotFoundException;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final UserRepository userRepository;

    @Autowired
    public PersonService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Person> findAll() {
        return userRepository.findAll();
    }

    public Person findOne(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    public Boolean isLoginExist(String login) {
        return userRepository.findByLogin(login).isPresent();
    }

    public Boolean isEmailExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public Boolean isPhoneExist(String phone) {
        return userRepository.findByPhone(phone).isPresent();
    }

    public Role getRoleById(Integer id) {
        Person person = findOne(id);

        return defineRole(person);
    }

    private Role defineRole(Person person) {
        if (person.getAdmin() != null) {
            return Role.ADMIN;
        } else if (person.getTeacher() != null) {
            return Role.TEACHER;
        } else return Role.STUDENT;
    }

}
