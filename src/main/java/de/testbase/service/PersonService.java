package de.testbase.service;

import de.testbase.domain.Address;
import de.testbase.domain.Person;
import de.testbase.repository.AddressRepository;
import de.testbase.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PersonService {

    private static final DateFormat FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public PersonService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    @PostConstruct
    private void loadData() throws ParseException {
        Date birthDate = FORMAT.parse("30.09.1969");
        Person person = new Person("Sören", "Ehm", birthDate, "info@soeren-ehm.de");
        personRepository.save(person);

        Address address = new Address("Friedrichshulder Weg 23", "25469", "Halstenbek");
        address.setPerson(person);
        addressRepository.save(address);

        birthDate = FORMAT.parse("01.01.1970");
        person = new Person("Max", "Mustermann", birthDate, "info@max-mustermann.de");
        personRepository.save(person);
    }

    public Person getPersonByLastName(String lastName) throws Exception {
        Person person = personRepository.findByLastNameIgnoreCase(lastName);
        if (person == null) {
            throw new Exception(String.format("No person with lastname %s found.", lastName));
        }
        return person;
    }

    public Person getPersonByLastNameAndBirthYear(String lastName, int birthYear) {
        return personRepository.findByLastNameAndBirthYear(lastName, birthYear);
    }

}
