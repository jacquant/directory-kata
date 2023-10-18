package wtf.jacquant.directorykata.controllers.json.company;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CompanyUpdatedJson extends CompanyJson {

    @NotNull
    @Min(1)
    private Long id;
}
