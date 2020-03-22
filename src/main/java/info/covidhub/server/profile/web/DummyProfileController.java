package info.covidhub.server.profile.web;

import info.covidhub.server.profile.data.Profile;
import info.covidhub.server.profile.data.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/profiles")
public class DummyProfileController {

    private ProfileRepository profileRepository;

    @Autowired
    public DummyProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @GetMapping(path = "/{id}")
    public Profile getProfile(@PathVariable Long id) {
        return profileRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No Profile found for ID: " + id)
        );
    }

    @PostMapping()
    public Profile createProfile(@RequestBody Profile profile) {
        return profileRepository.save(profile);
    }

    @PutMapping(path = "/{id}")
    public Profile updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        profile.setId(id);
        return profileRepository.save(profile);
    }
}
