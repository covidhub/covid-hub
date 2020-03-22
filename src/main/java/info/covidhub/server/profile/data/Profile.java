package info.covidhub.server.profile.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String location;

    private Long yearOfBirth;

    private String preexistingConditions;

    public Profile(String name, String email, String location, Long yearOfBirth, String preexistingConditions) {
        this.name = name;
        this.email = email;
        this.location = location;
        this.yearOfBirth = yearOfBirth;
        this.preexistingConditions = preexistingConditions;
    }
}
