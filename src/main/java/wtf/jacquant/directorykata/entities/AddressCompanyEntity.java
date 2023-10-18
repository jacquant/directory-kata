package wtf.jacquant.directorykata.entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("COMPANY")
@Getter
@Setter
public class AddressCompanyEntity extends AddressEntity {

    @OneToOne(mappedBy = "address")
    private CompanyEntity company;
}
