package wtf.jacquant.directorykata.mappers;

import org.mapstruct.*;
import wtf.jacquant.directorykata.configurations.MappingConfig;
import wtf.jacquant.directorykata.controllers.json.contact.*;
import wtf.jacquant.directorykata.domains.Contact;
import wtf.jacquant.directorykata.entities.ContactEntity;

import java.util.List;

@Mapper(config = MappingConfig.class, uses = {CompanyMapper.class, AddressMapper.class})
public interface ContactMapper {

    // Domain
    Contact toDomainFromEntity(ContactEntity entity);

    List<Contact> toDomainFromEntity(Iterable<ContactEntity> entities);

    @Mapping(target = "id", ignore = true)
    Contact toDomain(ContactCreateJson json);

    Contact toDomain(ContactUpdateJson json);

    // Json
    ContactGetJson toGetJson(Contact domain);

    List<ContactGetJson> toGetJson(Iterable<Contact> domains);

    ContactCreatedJson toCreatedJson(Contact domain);

    ContactUpdatedJson toUpdatedJson(Contact domain);

    // Entity
    ContactEntity toEntity(Contact domain);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateContactEntity(Contact domain, @MappingTarget ContactEntity entity);
}
