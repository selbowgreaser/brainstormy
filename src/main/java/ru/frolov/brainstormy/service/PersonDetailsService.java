package ru.frolov.brainstormy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.frolov.brainstormy.model.Person;
import ru.frolov.brainstormy.repository.PersonRepository;
import ru.frolov.brainstormy.security.PersonDetails;

import java.util.Optional;

@Service
public class PersonDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> user = personRepository.findByLogin(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found!");
        }

        return new PersonDetails(user.get());
    }
}
