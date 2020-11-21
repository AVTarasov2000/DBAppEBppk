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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;
    @Column(name = "name")
    @Getter @Setter
    private String name;
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @Getter @Setter @Many
    private Set <Book> books = new HashSet <>();
}
