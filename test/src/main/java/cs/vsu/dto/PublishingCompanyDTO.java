package cs.vsu.dto;

import cs.vsu.annotations.DTODAO;
import cs.vsu.annotations.Many;
import cs.vsu.models.PublishingCompany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@DTODAO(targetClass = PublishingCompany.class)
public class PublishingCompanyDTO {
    @Getter
    @Setter
    Integer id;
    @Getter @Setter
    String name;

    @Getter @Setter @Many
    Set <BookDTO> books = new HashSet <>();
}
