package wtf.jacquant.directorykata.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import wtf.jacquant.directorykata.domains.ContactType;

import java.util.List;

import static jakarta.persistence.InheritanceType.SINGLE_TABLE;

@Getter
@Setter
@Entity
@Table(name = "Contact")
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_gen")
    @SequenceGenerator(name = "contact_gen", sequenceName = "contact_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ContactType type;

    @Column(nullable = true)
    private String vatNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;

    @ManyToMany
    private List<CompanyEntity> companies;
}
