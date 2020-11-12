package cs.vsu.dto;

import cs.vsu.annotations.DTO;
import cs.vsu.annotations.Many;
import cs.vsu.models.Author;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@DTO(targetClass = Author.class)
public class AuthorDTO {
    @Getter
    @Setter
    Integer id;
    @Getter @Setter
    String name;
    @Getter @Setter @Many
    Set <BookDTO> books = new HashSet <>();;
}
