package cs.vsu.dto;


import cs.vsu.annotations.DTODAO;
import cs.vsu.annotations.One;
import cs.vsu.models.BookMark;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@DTODAO(targetClass = BookMark.class)
public class BookMarkDTO {

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
//    @Getter @Setter @One
//    private UserDTO user;
}
