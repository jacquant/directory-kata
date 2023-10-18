package wtf.jacquant.directorykata.mappers;

import org.mapstruct.*;
import wtf.jacquant.directorykata.configurations.MappingConfig;
import wtf.jacquant.directorykata.controllers.json.company.*;
import wtf.jacquant.directorykata.domains.Company;
import wtf.jacquant.directorykata.entities.CompanyEntity;

import java.util.List;

@Mapper(config = MappingConfig.class, uses = {AddressMapper.class})
public interface CompanyMapper {

    // Domain
    @Mapping(target = "id", ignore = true)
    Company toDomainFromJson(CompanyCreateJson json);

    Company toDomainFromJson(CompanyUpdateJson json);

    Company toDomainFromEntity(CompanyEntity entity);

    List<Company> toDomainFromEntity(Iterable<CompanyEntity> entities);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "vatNumber", ignore = true)
    @Mapping(target = "address", ignore = true)
    Company toDomainFromLong(Long id);

    // Json
    CompanyGetJson toGetJson(Company domain);

    List<CompanyGetJson> toGetJson(Iterable<Company> domains);

    CompanyCreatedJson toCreatedJson(Company domain);

    CompanyUpdatedJson toUpdatedJson(Company domain);


    // Entity
    CompanyEntity toEntity(Company domain);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCompanyEntity(Company domain, @MappingTarget CompanyEntity entity);
}
