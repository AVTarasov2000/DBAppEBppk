package cs.vsu.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
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

}
