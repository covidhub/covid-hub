package info.covidhub.server.contacts.data;

import info.covidhub.server.profile.data.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    @EmbeddedId
    private ContactId id;

    @ManyToOne
    @MapsId("profileAId")
    private Profile a;

    @ManyToOne
    @MapsId("profileBId")
    private Profile b;

    private Date date;

    public Contact(Profile a, Profile b, Date date) {
        this.id = new ContactId(a.getId(), b.getId());
        this.a = a;
        this.b = b;
        this.date = date;
    }
}
