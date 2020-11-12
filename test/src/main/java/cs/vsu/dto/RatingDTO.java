package cs.vsu.dto;

import cs.vsu.annotations.DTODAO;
import cs.vsu.annotations.Many;
import cs.vsu.models.Rating;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@DTODAO(targetClass = Rating.class)
public class RatingDTO {
    @Getter
    @Setter
    private Integer id;
    @Getter @Setter
    private String name;

    @Getter @Setter @Many
    private Set <UsersRatingDTO> usersRatings = new HashSet <>();
}
