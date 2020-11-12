package cs.vsu.models;

import cs.vsu.annotations.DTODAO;
import cs.vsu.annotations.One;
import cs.vsu.dto.BookMarkDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "library.book_mark", schema = "library")
@DTODAO(targetClass = BookMarkDTO.class)
public class BookMark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    Integer id;
    @Column(name = "book_id")
    @Getter @Setter
    Integer bookId;
    @Column(name = "user_id")
    @Getter @Setter
    Integer userId;
    @Column(name = "page")
    @Getter @Setter
    Integer page;
    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    @Getter @Setter @One
    Book books;
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @Getter @Setter @One
    User user;
}
