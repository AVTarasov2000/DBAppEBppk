package cs.vsu.dto;

import cs.vsu.annotations.DTODAO;
import cs.vsu.annotations.Many;
import cs.vsu.annotations.One;
import cs.vsu.annotations.Skip;
import cs.vsu.models.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@DTODAO(targetClass = Book.class)
public class BookDTO {

    @Getter
    @Setter
    private Integer bookId;
    @Getter @Setter
    private String bookName;
    @Getter @Setter
    private Date bookReleaseDate;
    @Getter @Setter
    private String bookLinkToFile;
    @Getter @Setter
    private Integer bookCompanyId;
    @Getter @Setter @Many
    private Set <AuthorDTO> authors = new HashSet <>();
    @Getter @Setter @Many
    private Set <GenreDTO> genres= new HashSet <>();
    @Getter @Setter @Skip
    private PublishingCompanyDTO publishingCompany;

}
