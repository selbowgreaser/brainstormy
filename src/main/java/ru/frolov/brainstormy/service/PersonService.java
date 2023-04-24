package ru.frolov.brainstormy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.frolov.brainstormy.model.Person;
import ru.frolov.brainstormy.repository.PersonRepository;
import ru.frolov.brainstormy.util.exception.PersonNotFoundException;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findOne(Integer id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    public Boolean isLoginExist(String login) {
        return personRepository.findByLogin(login).isPresent();
    }

    public Boolean isEmailExist(String email) {
        return personRepository.findByEmail(email).isPresent();
    }

    public Boolean isPhoneExist(String phone) {
        return personRepository.findByPhone(phone).isPresent();
    }



}
