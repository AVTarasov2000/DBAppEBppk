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
    Integer id;
    @Getter @Setter
    String name;

    @Getter @Setter @Many
    Set <UsersRatingDTO> usersRatings = new HashSet <>();
}
