package ru.frolov.brainstormy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.frolov.brainstormy.model.Person;
import ru.frolov.brainstormy.model.Student;
import ru.frolov.brainstormy.repository.PersonRepository;

import java.time.LocalDateTime;

@Service
public class RegistrationService {

    private final PersonRepository personRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(PersonRepository personRepository, BCryptPasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setCreatedAt(LocalDateTime.now());
        person.setUpdatedAt(LocalDateTime.now());

        Student student = new Student();
        student.setPerson(person);

        person.setStudent(student);

        personRepository.save(person);
    }
}
