package cs.vsu.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="library.author", schema = "library")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    Integer id;
    @Column(name = "name")
    @Getter @Setter
    String name;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "book_author",
            joinColumns = { @JoinColumn(name = "author_id") },
            inverseJoinColumns = { @JoinColumn(name = "id") }
    )
    @Getter @Setter
    Set <Book> books = new HashSet <>();;
}
