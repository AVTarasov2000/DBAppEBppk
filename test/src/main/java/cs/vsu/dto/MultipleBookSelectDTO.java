package cs.vsu.dto;

import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class MultipleBookSelectDTO {

    private Integer bookId;
    private String bookName;
    private Date bookReleaseDateFrom;
    private Date bookReleaseDateTo;
    private Integer bookCompanyId;
    private List <Integer> authorIds = new ArrayList <>();
    private List <Integer> genreIds = new ArrayList <>();

}
