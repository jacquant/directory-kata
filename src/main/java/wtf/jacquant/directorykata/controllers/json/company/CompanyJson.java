package wtf.jacquant.directorykata.controllers.json.company;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import wtf.jacquant.directorykata.controllers.json.address.AddressJson;

@Data
public class CompanyJson {

    @NotBlank
    private String name;
    @Pattern(regexp = "^BE\\d{10}$")
    private String vatNumber;
    @Valid
    @NotNull
    private AddressJson address;

}

