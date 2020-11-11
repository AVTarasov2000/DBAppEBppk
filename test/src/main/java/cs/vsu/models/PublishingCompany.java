package cs.vsu.models;

import cs.vsu.annotations.DAO;
import cs.vsu.dto.PublishingCompanyDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "library.publishing_company", schema = "library")
@DAO(targetClass = PublishingCompanyDTO.class)
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
