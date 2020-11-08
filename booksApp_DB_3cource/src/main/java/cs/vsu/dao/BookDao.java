package cs.vsu.dao;

import cs.vsu.models.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookDao implements Dao<Book>{

    SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Book findById(Integer id, Class tClass) {
        return null;
    }

    @Override
    @Transactional
    public void save(Book book) {

    }

    @Override
    @Transactional
    public void delete(Book book) {

    }

    @Override
    @Transactional
    public void update(Book book) {

    }

    @Override
    @Transactional
    public List <Book> getAll(Integer id, Class tClass) {
        return null;
    }
}
