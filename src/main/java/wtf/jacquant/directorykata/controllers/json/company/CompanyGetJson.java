package wtf.jacquant.directorykata.controllers.json.company;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CompanyGetJson extends CompanyJson {
    private Long id;
}
