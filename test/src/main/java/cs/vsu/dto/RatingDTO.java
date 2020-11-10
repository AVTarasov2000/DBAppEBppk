package cs.vsu.dto;

import cs.vsu.annotations.DTO;
import cs.vsu.models.Rating;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@DTO(targetClass = Rating.class)
public class RatingDTO {
    @Getter
    @Setter
    Integer id;
    @Getter @Setter
    String name;

    @Getter @Setter
    Set <UsersRatingDTO> usersRatings;
}
