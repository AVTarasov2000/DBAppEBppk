package cs.vsu.models;

import cs.vsu.annotations.DTODAO;
import cs.vsu.annotations.One;
import cs.vsu.dto.UsersRatingDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "library.read_book", schema = "library")
@DTODAO(targetClass = UsersRatingDTO.class)
public class UsersRating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Integer id;
    @Column(name = "book_id")
    @Getter @Setter
    private Integer bookId;
    @Column(name = "user_id")
    @Getter @Setter
    private Integer userId;
    @Column(name = "rating")
    @Getter @Setter
    private Integer page;
    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    @Getter @Setter @One
    private Book books;
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @Getter @Setter @One
    private User user;
    @ManyToOne
    @JoinColumn(name = "rating", insertable = false, updatable = false)
    @Getter @Setter @One
    private Rating rating;

}
