package wtf.jacquant.directorykata.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wtf.jacquant.directorykata.domains.Company;
import wtf.jacquant.directorykata.exceptions.CompanyNotFoundException;
import wtf.jacquant.directorykata.mappers.CompanyMapper;
import wtf.jacquant.directorykata.repositories.CompanyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyService {

    private final CompanyRepository repository;
    private final CompanyMapper mapper;


    public List<Company> findAllCompanies() {
        return mapper.toDomainFromEntity(repository.findAll());
    }

    public Company getCompanyByVatNumber(final String vatNumber) {
        return mapper.toDomainFromEntity(repository.findByVatNumber(vatNumber));
    }

    public Company createCompany(final Company company) {
        return mapper.toDomainFromEntity(repository.save(mapper.toEntity(company)));
    }

    public Company updateCompany(final Company company) {
        return repository.findById(company.id())
                .map(entity -> {
                    mapper.updateCompanyEntity(company, entity);
                    repository.save(entity);
                    return mapper.toDomainFromEntity(entity);
                })
                .orElseThrow(() -> new CompanyNotFoundException(company.id()));
    }
}
