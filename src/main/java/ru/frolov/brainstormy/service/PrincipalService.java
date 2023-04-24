package ru.frolov.brainstormy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.frolov.brainstormy.model.Person;
import ru.frolov.brainstormy.model.Role;
import ru.frolov.brainstormy.repository.PersonRepository;
import ru.frolov.brainstormy.util.exception.PersonNotFoundException;

import java.security.Principal;

@Service
@Transactional(readOnly = true)
public class PrincipalService {

    private final PersonRepository personRepository;

    @Autowired
    public PrincipalService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findByPrincipal(Principal principal) {
        String login = principal.getName();
        return personRepository.findByLogin(login).orElseThrow(() -> new PersonNotFoundException(login));
    }

    public Role getRoleByPerson(Person person) {
        if (person.getAdmin() != null) {
            return Role.ADMIN;
        } else if (person.getTeacher() != null) {
            return Role.TEACHER;
        } else return Role.STUDENT;
    }

}
