package wtf.jacquant.directorykata.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wtf.jacquant.directorykata.domains.Contact;
import wtf.jacquant.directorykata.exceptions.ContactNotFoundException;
import wtf.jacquant.directorykata.mappers.ContactMapper;
import wtf.jacquant.directorykata.repositories.ContactRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ContactService {

    private final ContactRepository repository;
    private final ContactMapper mapper;


    public List<Contact> findAllContacts() {
        return mapper.toDomainFromEntity(repository.findAll());
    }

    public Contact createContact(Contact contact) {
        return mapper.toDomainFromEntity(repository.save(mapper.toEntity(contact)));
    }

    public void removeContact(Long id) {
        repository.deleteById(id);
    }

    public Contact updateContact(Contact contact) {
        return repository.findById(contact.id())
                .map(entity -> {
                    mapper.updateContactEntity(contact, entity);
                    repository.save(entity);
                    return mapper.toDomainFromEntity(entity);
                })
                .orElseThrow(() -> new ContactNotFoundException(contact.id()));
    }
}
