package wtf.jacquant.directorykata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import wtf.jacquant.directorykata.entities.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {

    CompanyEntity findByVatNumber(String vatNumber);
}
