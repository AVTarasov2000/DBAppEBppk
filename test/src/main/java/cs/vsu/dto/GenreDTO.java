package cs.vsu.dto;

import cs.vsu.annotations.DTO;
import cs.vsu.annotations.Many;
import cs.vsu.models.Genre;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@DTO(targetClass = Genre.class)
public class GenreDTO {

    @Getter
    @Setter
    Integer id;
    @Getter @Setter
    String name;

    @Getter @Setter @Many
    Set <BookDTO> books = new HashSet <>();
}
