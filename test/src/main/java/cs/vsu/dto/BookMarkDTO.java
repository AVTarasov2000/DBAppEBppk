package cs.vsu.dto;


import cs.vsu.annotations.DTO;
import cs.vsu.annotations.One;
import cs.vsu.models.BookMark;
import lombok.Getter;
import lombok.Setter;

@DTO(targetClass = BookMark.class)
public class BookMarkDTO {

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
}
