package de.testbase;

import de.testbase.domain.Person;
import de.testbase.repository.PersonRepository;
import de.testbase.service.PersonService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class CustomMockitoTests {

    private static final DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

    @Rule
    public ExpectedException thrownException = ExpectedException.none();

	@InjectMocks
	private PersonService personService;

	@Mock
    private PersonRepository personRepository;

    private Person person;

    @Before
    public void init() throws Exception {
        person = new Person("Sören", "Ehm", formatter.parse("30.09.1969"), "info@soeren-ehm.de");
    }

    @Test
	public void personalFoundByLastName() throws Exception {
	    when(personRepository.findByLastNameIgnoreCase("ehm")).thenReturn(person);
        assertEquals("Ehm", personService.getPersonByLastName("ehm").getLastName());
	}

    @Test
    @SuppressWarnings("unused")
    public void personalNotFoundByLastNameThrowException() throws Exception {
        thrownException.expect(Exception.class);
        thrownException.expectMessage(String.format("No person with lastname %s found.", "unknown"));

        when(personRepository.findByLastNameIgnoreCase("ehm")).thenReturn(person);
        String lastName = personService.getPersonByLastName("unknown").getLastName();
    }
}
