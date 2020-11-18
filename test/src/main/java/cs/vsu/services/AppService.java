package cs.vsu.services;

import cs.vsu.dto.*;

import java.util.List;

public interface AppService {
    List <AuthorDTO> getAllAuthors();
    boolean isExist(UserDTO user);
    public UserDTO getUser(UserDTO user);
    List<BookDTO> getAllBooks();
    List<GenreDTO> getAllGenres();
    List<PublishingCompanyDTO> getAllCompanys();
    void addAuthor(AuthorDTO authorDTO);
    void deleteAuthor(AuthorDTO authorDTO);
    void updateAuthor(AuthorDTO authorDTO);
    void addCompany(PublishingCompanyDTO publishingCompanyDTO);
    void deleteCompany(PublishingCompanyDTO publishingCompanyDTO);
    void updateCompany(PublishingCompanyDTO publishingCompanyDTO);
    void addGenre(GenreDTO genreDTO);
    void deleteGenre(GenreDTO genreDTO);
    void updateGenre(GenreDTO genreDTO);
}
