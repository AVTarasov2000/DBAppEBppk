package cs.vsu.models;


import cs.vsu.annotations.DTODAO;
import cs.vsu.annotations.Many;
import cs.vsu.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "library.user", schema = "library")
@DTODAO(targetClass = UserDTO.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    private Integer id;
    @Column(name = "login")
    @Getter @Setter
    private String login;
    @Column(name = "password")
    @Getter @Setter
    private String password;
    @Column(name = "name")
    @Getter @Setter
    private String name;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "library.book_mark",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "id") }
    )
//    @JoinColumn(name = "id")
    @Getter @Setter @Many
    private Set <Book> books = new HashSet <>();

}
