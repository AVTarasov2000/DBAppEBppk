package cs.vsu.dao;

import cs.vsu.models.Book;
import cs.vsu.models.User;

import java.util.List;

public interface BookMarkDao {
    List<Book> getUsersBooks(User user);
}