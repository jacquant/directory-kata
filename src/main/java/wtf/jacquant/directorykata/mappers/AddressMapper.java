package wtf.jacquant.directorykata.mappers;

import org.mapstruct.*;
import wtf.jacquant.directorykata.configurations.MappingConfig;
import wtf.jacquant.directorykata.controllers.json.address.AddressJson;
import wtf.jacquant.directorykata.domains.Address;
import wtf.jacquant.directorykata.entities.AddressEntity;

@Mapper(config = MappingConfig.class)
public interface AddressMapper {

    // Domain
    @Mapping(target = "id", ignore = true)
    Address toDomain(AddressJson json);

    // Json
    AddressJson toJson(Address domain);

    // Entity
    AddressEntity toEntity(Address domain);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAddressEntity(Address domain, @MappingTarget AddressEntity entity);
}
