package cs.vsu.dto;

import cs.vsu.annotations.DTODAO;
import cs.vsu.annotations.Many;
import cs.vsu.models.Author;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@DTODAO(targetClass = Author.class)
public class AuthorDTO {
    @Getter
    @Setter
    private Integer id;
    @Getter @Setter
    private String name;
    @Getter @Setter @Many
    private Set <BookDTO> books = new HashSet <>();;
}
