package cs.vsu.dto;

import cs.vsu.annotations.DTO;
import cs.vsu.annotations.Many;
import cs.vsu.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@DTO(targetClass = User.class)
public class UserDTO {
    @Getter
    @Setter
    Integer id;
    @Getter @Setter
    String login;
    @Getter @Setter
    String password;
    @Getter @Setter
    String name;
    @Getter @Setter @Many
    Set <BookMarkDTO> bookMarks = new HashSet <>();

}
