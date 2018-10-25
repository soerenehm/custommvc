package de.testbase.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private Date birthDate;
    private String eMail;


    public Person (String firstname, String lastname, Date birthDate, String eMail) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.birthDate = birthDate;
        this.eMail = eMail;
    }

    @OneToMany (mappedBy = "person")
    private List<Address> addresses;
}
