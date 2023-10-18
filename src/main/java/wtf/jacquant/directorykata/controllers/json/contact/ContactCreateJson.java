package wtf.jacquant.directorykata.controllers.json.contact;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ContactCreateJson extends ContactJson {

    List<Long> companies;
}
