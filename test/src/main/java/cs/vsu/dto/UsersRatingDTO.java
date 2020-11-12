package cs.vsu.dto;

import cs.vsu.annotations.DTODAO;
import cs.vsu.annotations.One;
import cs.vsu.models.UsersRating;
import lombok.Getter;
import lombok.Setter;

@DTODAO(targetClass = UsersRating.class)
public class UsersRatingDTO {
    @Getter
    @Setter
    private Integer id;
    @Getter @Setter
    private Integer bookId;
    @Getter @Setter
    private Integer userId;
    @Getter @Setter
    private Integer page;
    @Getter @Setter @One
    private BookDTO books;
    @Getter @Setter @One
    private UserDTO user;
    @Getter @Setter @One
    private RatingDTO rating;
}
