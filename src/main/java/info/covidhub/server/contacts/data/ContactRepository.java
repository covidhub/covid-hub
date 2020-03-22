package info.covidhub.server.contacts.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, ContactId> {

    List<Contact> findAllByA_Id(Long id);

    List<Contact> findAllByB_Id(Long id);
}
