package cs.vsu.services;

import cs.vsu.dao.Dao;
import cs.vsu.dto.AuthorDTO;
import cs.vsu.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {


    Dao<Author> dao;

    @Autowired
    public void setDao(Dao <Author> dao) {
        this.dao = dao;
    }


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
