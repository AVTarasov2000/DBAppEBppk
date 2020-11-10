package cs.vsu.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "library.user", schema = "library")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    @Column(name = "id")
    Integer id;
    @Column(name = "login")
    @Getter @Setter
    String login;
    @Column(name = "password")
    @Getter @Setter
    String password;
    @Column(name = "name")
    @Getter @Setter
    String name;
    @OneToMany
    @JoinColumn(name = "user_id")
    @Getter @Setter
    Set <BookMark> bookMarks;

}
