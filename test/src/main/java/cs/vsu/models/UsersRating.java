package cs.vsu.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "read_book")
public class UsersRating {
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
    @Column(name = "rating")
    @Getter @Setter
    Integer page;
    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    @Getter @Setter
    Book books;
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @Getter @Setter
    User user;
    @ManyToOne
    @JoinColumn(name = "rating", insertable = false, updatable = false)
    @Getter @Setter
    Rating rating;

}
