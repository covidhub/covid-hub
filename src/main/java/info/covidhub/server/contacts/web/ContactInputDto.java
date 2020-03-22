package info.covidhub.server.contacts.web;

import lombok.Value;

import java.util.Date;
import java.util.List;

@Value
public class ContactInputDto {

    Long id;

    List<Long> contactIds;

    Date date;
}
