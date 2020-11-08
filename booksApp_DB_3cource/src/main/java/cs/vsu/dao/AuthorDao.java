package cs.vsu.dao;

import cs.vsu.models.Author;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AuthorDao implements Dao<Author>{


    SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Author findById(Integer id, Class tClass) {
        return null;
    }

    @Override
    @Transactional
    public void save(Author author) {

    }

    @Override
    @Transactional
    public void delete(Author author) {

    }

    @Override
    @Transactional
    public void update(Author author) {

    }

    @Override
    @Transactional
    public List <Author> getAll(Integer id, Class tClass) {
        return null;
    }
}
