package wtf.jacquant.directorykata.controllers.json.contact;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ContactUpdateJson extends ContactJson {
    @NotNull
    @Min(1)
    private Long id;
    @NotEmpty
    private List<Long> companies;
}
