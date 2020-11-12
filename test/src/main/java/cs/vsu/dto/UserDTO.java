package cs.vsu.dto;

import cs.vsu.annotations.DTODAO;
import cs.vsu.annotations.Many;
import cs.vsu.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@DTODAO(targetClass = User.class)
public class UserDTO {
    @Getter
    @Setter
    private Integer id;
    @Getter @Setter
    private String login;
    @Getter @Setter
    private String password;
    @Getter @Setter
    private String name;
    @Getter @Setter @Many
    private Set <BookMarkDTO> bookMarks = new HashSet <>();

}
