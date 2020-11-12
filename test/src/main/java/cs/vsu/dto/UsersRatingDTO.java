package cs.vsu.dto;

import cs.vsu.annotations.DTO;
import cs.vsu.annotations.One;
import cs.vsu.models.UsersRating;
import lombok.Getter;
import lombok.Setter;

@DTO(targetClass = UsersRating.class)
public class UsersRatingDTO {
    @Getter
    @Setter
    Integer id;
    @Getter @Setter
    Integer bookId;
    @Getter @Setter
    Integer userId;
    @Getter @Setter
    Integer page;
    @Getter @Setter @One
    BookDTO books;
    @Getter @Setter @One
    UserDTO user;
    @Getter @Setter @One
    RatingDTO rating;
}
