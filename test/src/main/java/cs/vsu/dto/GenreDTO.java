package cs.vsu.dto;

import cs.vsu.annotations.DTODAO;
import cs.vsu.annotations.Many;
import cs.vsu.models.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@DTODAO(targetClass = Genre.class)
public class GenreDTO {

    @Getter
    @Setter
    private Integer id;
    @Getter @Setter
    private String name;

    @Getter @Setter @Many
    private Set <BookDTO> books = new HashSet <>();
}
