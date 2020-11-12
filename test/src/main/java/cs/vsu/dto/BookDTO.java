package cs.vsu.dto;

import cs.vsu.annotations.DTODAO;
import cs.vsu.annotations.Many;
import cs.vsu.annotations.One;
import cs.vsu.models.Book;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@DTODAO(targetClass = Book.class)
public class BookDTO {

    @Getter
    @Setter
    private Integer id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private Date releaseDate;
    @Getter @Setter
    private String linkToFile;
    @Getter @Setter
    private Integer companyId;
    @Getter @Setter @Many
    private Set <AuthorDTO> authors = new HashSet <>();
    @Getter @Setter @Many
    private Set <GenreDTO> genres= new HashSet <>();
    @Getter @Setter @One
    private PublishingCompanyDTO publishingCompany;

}
