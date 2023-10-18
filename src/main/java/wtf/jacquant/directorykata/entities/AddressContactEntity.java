package wtf.jacquant.directorykata.entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("CONTACT")
@Getter
@Setter
public class AddressContactEntity extends AddressEntity {

    @OneToOne(mappedBy = "address")
    private ContactEntity contact;
}
