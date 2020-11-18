package cs.vsu.models;


import cs.vsu.annotations.DTODAO;
import cs.vsu.annotations.Many;
import cs.vsu.dto.AuthorDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="library.author", schema = "library")
@DTODAO(targetClass = AuthorDTO.class)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name = "id")
    private Integer authorId;
    @Column(name = "name")
    @Getter @Setter
    private String authorName;
//    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "library.book_author",
//            joinColumns = { @JoinColumn(name = "author_id") },
//            inverseJoinColumns = { @JoinColumn(name = "id") }
//    )
//    @Getter @Setter @Many
//    private Set <Book> books = new HashSet <>();;
}
