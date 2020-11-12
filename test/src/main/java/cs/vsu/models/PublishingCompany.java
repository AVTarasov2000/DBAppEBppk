package cs.vsu.models;

import cs.vsu.annotations.DTODAO;
import cs.vsu.annotations.Many;
import cs.vsu.dto.PublishingCompanyDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "library.publishing_company", schema = "library")
@DTODAO(targetClass = PublishingCompanyDTO.class)
public class PublishingCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Integer id;
    @Column(name = "name")
    @Getter @Setter
    private String name;
    @OneToMany
    @JoinColumn(name = "company_id")
    @Getter @Setter @Many
    private Set <Book> books = new HashSet <>();
}
