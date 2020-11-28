package cs.vsu.dao;

import cs.vsu.models.Book;
import cs.vsu.models.User;

import java.util.List;

public interface BookDao {
    List<Book> getAllBooks();
    void addBook(Book book);
    String middleRating(Integer bookId);
    }
