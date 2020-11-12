package cs.vsu.models;

import cs.vsu.annotations.DAO;
import cs.vsu.dto.RatingDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "library.rating", schema = "library")
@DAO(targetClass = RatingDTO.class)
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
    Set <UsersRating> usersRatings = new HashSet <>();
}
