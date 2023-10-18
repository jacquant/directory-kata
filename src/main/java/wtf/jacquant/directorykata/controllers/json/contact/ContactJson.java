package wtf.jacquant.directorykata.controllers.json.contact;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import wtf.jacquant.directorykata.controllers.json.address.AddressJson;
import wtf.jacquant.directorykata.domains.ContactType;

@Data
public class ContactJson {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Valid
    private AddressJson address;
    @NotNull
    private ContactType type;
    private String vatNumber;

}
