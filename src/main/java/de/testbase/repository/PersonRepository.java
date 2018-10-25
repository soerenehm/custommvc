package de.testbase.repository;

import de.testbase.domain.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findByLastNameIgnoreCase(String lastName);

    @Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(?1) AND YEAR(p.birthDate) = ?2")
    Person findByLastNameAndBirthYear(String lastName, int year);
}
