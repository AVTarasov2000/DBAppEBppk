package cs.vsu.dto;

import cs.vsu.annotations.DTO;
import cs.vsu.models.PublishingCompany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@DTO(targetClass = PublishingCompany.class)
public class PublishingCompanyDTO {
    @Getter
    @Setter
    Integer id;
    @Getter @Setter
    String name;

    @Getter @Setter
    Set <BookDTO> books = new HashSet <>();
}
