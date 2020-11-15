package cs.vsu.services;

import cs.vsu.dto.AuthorDTO;
import cs.vsu.dto.BookDTO;
import cs.vsu.dto.BookMarkDTO;
import cs.vsu.dto.UserDTO;

import java.util.List;

public interface AppService {
    List <AuthorDTO> getAllAuthors();
    boolean isExist(UserDTO user);
    public UserDTO getUser(UserDTO user);
    List<BookDTO> getAllBooks(UserDTO user);
}
