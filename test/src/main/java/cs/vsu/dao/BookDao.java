package cs.vsu.dao;

import cs.vsu.models.Book;
import cs.vsu.models.User;

import java.util.List;

public interface BookDao {
    List<Book> getAllBooks();
    void addBook(Book book);
    void addBookAuthor(Integer bookId, Integer authorId);
    void deleteBookAuthor(Integer bookId, Integer authorId);
    void deleteBookGenre(Integer bookId, Integer genreId);
    void addBookGenre(Integer bookId, Integer genreId);
    }
