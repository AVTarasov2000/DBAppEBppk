package cs.vsu.models;

import cs.vsu.annotations.DAO;
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
@DAO(targetClass = BookDTO.class)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    Integer id;
    @Column(name = "name")
    @Getter @Setter
    String name;
    @Column(name = "release_date")
    @Getter @Setter
    Date releaseDate;
    @Column(name = "link_to_file")
    @Getter @Setter
    String linkToFile;
    @Column(name = "company_id", insertable = false, updatable = false)
    @Getter @Setter
    Integer companyId;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "book_author",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "id") }
    )
    @Getter @Setter @Many
    Set <Author> authors = new HashSet <>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "book_genre",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "id") }
    )
    @Getter @Setter @Many
    Set <Genre> genres = new HashSet <>();

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "company_id")
    @Getter @Setter @One
    PublishingCompany publishingCompany;
}
