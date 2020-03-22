package info.covidhub.server.contacts.web;

import info.covidhub.server.contacts.data.Contact;
import lombok.Value;

import java.util.Date;

@Value
public class ContactOutputDto {

    Long id;

    String name;

    String email;

    String location;

    Long yearOfBirth;

    Date lastContact;

    public ContactOutputDto(Contact contact) {
        this.id = contact.getB().getId();
        this.name = contact.getB().getName();
        this.email = contact.getB().getEmail();
        this.location = contact.getB().getLocation();
        this.yearOfBirth = contact.getB().getYearOfBirth();
        this.lastContact = contact.getDate();
    }
}
