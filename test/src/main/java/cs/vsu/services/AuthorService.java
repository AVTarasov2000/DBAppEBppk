package cs.vsu.services;

import cs.vsu.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {
    public AuthorDTO findAuthor(int id);

    public void saveAuthor(AuthorDTO author);

    public void deleteAuthor(AuthorDTO author);

    public void updateAuthor(AuthorDTO author);

    public List <AuthorDTO> findAllAuthors();

}
