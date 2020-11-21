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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name = "id", nullable = false, unique = true)
    private Integer bookId;
    @Column(name = "name")
    @Getter @Setter
    private String bookName;
    @Column(name = "release_date")
    @Getter @Setter
    private Date bookReleaseDate;
    @Column(name = "link_to_file")
    @Getter @Setter
    private String bookLinkToFile;
    @Column(name = "company_id", insertable = false, updatable = false)
    @Getter @Setter
    private Integer bookCompanyId;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "library.book_author",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") }
    )
    @Getter @Setter @Many
    private Set <Author> authors = new HashSet <>();

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "library.book_genre",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "genre_id") }
    )
    @Getter @Setter @Many
    private Set <Genre> genres = new HashSet <>();

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    @Getter @Setter @One
    private PublishingCompany publishingCompany;
}
