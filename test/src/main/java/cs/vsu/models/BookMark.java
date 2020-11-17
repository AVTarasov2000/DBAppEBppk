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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;
    @Column(name = "book_id")
    @Getter @Setter
    private Integer bookId;
    @Column(name = "user_id")
    @Getter @Setter
    private Integer userId;
    @Column(name = "page")
    @Getter @Setter
    private Integer page;
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    @Getter @Setter @One
    private Book books;
//    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id", insertable = false, updatable = false)
//    @Getter @Setter @One
//    private User user;
}
