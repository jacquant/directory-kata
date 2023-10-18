package wtf.jacquant.directorykata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import wtf.jacquant.directorykata.entities.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
}
