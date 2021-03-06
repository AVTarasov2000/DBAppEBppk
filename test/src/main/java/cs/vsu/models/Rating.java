package cs.vsu.models;

import cs.vsu.annotations.DTODAO;
import cs.vsu.annotations.Many;
import cs.vsu.dto.RatingDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "library.rating", schema = "library")
@DTODAO(targetClass = RatingDTO.class)
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;
    @Column(name = "rating")
    @Getter @Setter
    private String name;
    @OneToMany
    @JoinColumn(name = "id")
    @Getter @Setter @Many
    private Set <UsersRating> usersRatings = new HashSet <>();
}
