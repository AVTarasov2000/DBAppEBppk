package cs.vsu.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "library.rating", schema = "library")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    Integer id;
    @Column(name = "rating")
    @Getter @Setter
    String name;
    @OneToMany
    @JoinColumn(name = "id")
    @Getter @Setter
    Set <UsersRating> usersRatings;
}
