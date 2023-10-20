package wtf.jacquant.directorykata.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import wtf.jacquant.directorykata.controllers.json.contact.*;
import wtf.jacquant.directorykata.domains.Contact;
import wtf.jacquant.directorykata.mappers.ContactMapper;
import wtf.jacquant.directorykata.services.ContactService;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;
    private final ContactMapper mapper;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactCreatedJson createContact(@RequestBody @Valid final ContactCreateJson contactCreateJson) {
        final Contact contact = contactService.createContact(mapper.toDomain(contactCreateJson));
        return mapper.toCreatedJson(contact);
    }

    @PutMapping("/{id}")
    public ContactUpdatedJson updateContact(@PathVariable final Long id, @RequestBody @Valid final ContactUpdateJson contactUpdateJson) {
        if (!contactUpdateJson.getId().equals(id)) {
            throw new IllegalArgumentException("Contact id in path and body must be the same");
        }

        final Contact contact = contactService.updateContact(mapper.toDomain(contactUpdateJson));
        return mapper.toUpdatedJson(contact);
    }

    @GetMapping("")
    public List<ContactGetJson> getAllContacts() {
        return mapper.toGetJson(contactService.findAllContacts());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable @Min(1) final Long id) {
        contactService.removeContact(id);
    }
}
