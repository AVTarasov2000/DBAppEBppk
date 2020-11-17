package cs.vsu.models;

import cs.vsu.annotations.DTODAO;
import cs.vsu.annotations.Many;
import cs.vsu.dto.GenreDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "library.genre", schema = "library")
@DTODAO(targetClass = GenreDTO.class)
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    @Column(name = "name")
    @Getter @Setter
    private String name;


//    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "book_genre",
//            joinColumns = { @JoinColumn(name = "book_id") },
//            inverseJoinColumns = { @JoinColumn(name = "id") }
//    )
//    @Getter @Setter @Many
//    private Set <Book> books = new HashSet <>();

}
