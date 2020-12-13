package cs.vsu.dao;

import cs.vsu.dto.BookDTO;
import cs.vsu.dto.MultipleBookSelectDTO;
import cs.vsu.models.Author;
import cs.vsu.models.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAllBooks();
    void addBook(Book book);
    String middleRating(Integer bookId);
    List <Book> getTenBestBooks();
    List<Book> getBySelector(MultipleBookSelectDTO selectDTO);
}
