package cs.vsu.services;

import cs.vsu.dto.AuthorDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService {
    @Override
    public AuthorDTO findAuthor(int id) {
        return null;
    }

    @Override
    public void saveAuthor(AuthorDTO author) {

    }

    @Override
    public void deleteAuthor(AuthorDTO author) {

    }

    @Override
    public void updateAuthor(AuthorDTO author) {

    }

    @Override
    public List <AuthorDTO> findAllAuthors() {
        return null;
    }
}
