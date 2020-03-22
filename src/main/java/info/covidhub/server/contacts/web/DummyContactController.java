package info.covidhub.server.contacts.web;

import info.covidhub.server.contacts.data.Contact;
import info.covidhub.server.contacts.data.ContactRepository;
import info.covidhub.server.profile.data.Profile;
import info.covidhub.server.profile.data.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/contacts")
public class DummyContactController {

    private ContactRepository contactRepository;
    private ProfileRepository profileRepository;

    @Autowired
    public DummyContactController(ContactRepository contactRepository, ProfileRepository profileRepository) {
        this.contactRepository = contactRepository;
        this.profileRepository = profileRepository;
    }

    @GetMapping(path = "/{id}")
    public List<ContactOutputDto> getContact(@PathVariable Long id) {
        return contactRepository.findAllByA_Id(id)
            .stream()
            .map(ContactOutputDto::new)
            .collect(Collectors.toList());
    }

    // TODO Bi-directional contact
    @PostMapping
    public void createContact(@RequestBody ContactInputDto input) {
        Profile a = profileRepository.findById(input.getId()).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Profile found for ID: " + input.getId())
        );
        Iterable<Profile> contacts = profileRepository.findAllById(input.getContactIds());

        contacts.forEach(contact -> contactRepository.save(new Contact(a, contact, input.getDate())));
    }
}
