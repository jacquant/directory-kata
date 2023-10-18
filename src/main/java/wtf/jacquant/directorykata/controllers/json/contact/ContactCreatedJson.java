package wtf.jacquant.directorykata.controllers.json.contact;

import lombok.Data;
import lombok.EqualsAndHashCode;
import wtf.jacquant.directorykata.controllers.json.company.CompanyGetJson;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ContactCreatedJson extends ContactJson{
    private Long id;
    private List<CompanyGetJson> companies;
}
