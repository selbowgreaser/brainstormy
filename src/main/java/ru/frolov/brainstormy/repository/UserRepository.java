package ru.frolov.brainstormy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.frolov.brainstormy.model.Person;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByLogin(String login);

    Optional<Person> findByEmail(String email);

    Optional<Person> findByPhone(String phone);
}
