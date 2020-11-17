package cs.vsu.services;

import cs.vsu.dto.*;

import java.util.List;

public interface AppService {
    List <AuthorDTO> getAllAuthors();
    boolean isExist(UserDTO user);
    public UserDTO getUser(UserDTO user);
    List<BookDTO> getAllBooks(UserDTO user);
    List<GenreDTO> getAllGenres();
    List<PublishingCompanyDTO> getAllCompanys();
    void addAuthor(AuthorDTO authorDTO);
    void deleteAuthor(AuthorDTO authorDTO);
    void updateAuthor(AuthorDTO authorDTO);
}
