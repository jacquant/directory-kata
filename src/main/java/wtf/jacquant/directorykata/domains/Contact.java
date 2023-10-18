package wtf.jacquant.directorykata.domains;

import java.util.List;

public record Contact(Long id, String firstName, String lastName, Address address,
                      ContactType type, String vatNumber,
                      List<Company> companies
) {
}
