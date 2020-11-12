package cs.vsu.dto;

import cs.vsu.annotations.DTO;
import cs.vsu.annotations.Many;
import cs.vsu.annotations.One;
import cs.vsu.models.Book;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@DTO(targetClass = Book.class)
public class BookDTO {

    @Getter
    @Setter
    Integer id;
    @Getter @Setter
    String name;
    @Getter @Setter
    Date releaseDate;
    @Getter @Setter
    String linkToFile;
    @Getter @Setter
    Integer companyId;
    @Getter @Setter @Many
    Set <AuthorDTO> authors = new HashSet <>();
    @Getter @Setter @Many
    Set <GenreDTO> genres= new HashSet <>();
    @Getter @Setter @One
    PublishingCompanyDTO publishingCompany;

}
