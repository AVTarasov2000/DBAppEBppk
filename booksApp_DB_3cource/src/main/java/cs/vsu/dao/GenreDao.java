package cs.vsu.dao;

import cs.vsu.models.Genre;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class GenreDao implements Dao<Genre> {

    SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Genre findById(Integer id, Class tClass) {
        return null;
    }

    @Override
    @Transactional
    public void save(Genre genre) {

    }

    @Override
    @Transactional
    public void delete(Genre genre) {

    }

    @Override
    @Transactional
    public void update(Genre genre) {

    }

    @Override
    @Transactional
    public List <Genre> getAll(Integer id, Class tClass) {
        return null;
    }
}
