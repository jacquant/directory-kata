package wtf.jacquant.directorykata.controllers.json.contact;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.EqualsAndHashCode;
import wtf.jacquant.directorykata.controllers.json.company.CompanyGetJson;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ContactGetJson extends ContactJson {
    @Valid
    List<CompanyGetJson> companies;
}
