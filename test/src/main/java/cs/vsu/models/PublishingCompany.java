package cs.vsu.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "library.publishing_company", schema = "library")
public class PublishingCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    Integer id;
    @Column(name = "name")
    @Getter @Setter
    String name;
    @OneToMany
    @JoinColumn(name = "company_id")
    @Getter @Setter
    Set <Book> books;
}
