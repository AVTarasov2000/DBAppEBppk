package cs.vsu.models;

import cs.vsu.annotations.DTODAO;
import cs.vsu.annotations.Many;
import cs.vsu.annotations.One;
import cs.vsu.dto.BookDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "library.book", schema = "library")
@DTODAO(targetClass = BookDTO.class)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Integer id;
    @Column(name = "name")
    @Getter @Setter
    private String name;
    @Column(name = "release_date")
    @Getter @Setter
    private Date releaseDate;
    @Column(name = "link_to_file")
    @Getter @Setter
    private String linkToFile;
    @Column(name = "company_id", insertable = false, updatable = false)
    @Getter @Setter
    private Integer companyId;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "library.book_author",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "id") }
    )
    @Getter @Setter @Many
    private Set <Author> authors = new HashSet <>();

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "library.book_genre",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "id") }
    )
    @Getter @Setter @Many
    private Set <Genre> genres = new HashSet <>();

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "company_id")
    @Getter @Setter @One
    private PublishingCompany publishingCompany;
}
