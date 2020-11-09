package cs.vsu.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book_mark")
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
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    @Getter @Setter
    Book books;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @Getter @Setter
    User user;
}
