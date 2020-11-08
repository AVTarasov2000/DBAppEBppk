package cs.vsu.dao;

import cs.vsu.models.Rating;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class RatingDao implements Dao<Rating> {

    SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Rating findById(Integer id, Class tClass) {
        return null;
    }

    @Override
    @Transactional
    public void save(Rating rating) {

    }

    @Override
    @Transactional
    public void delete(Rating rating) {

    }

    @Override
    @Transactional
    public void update(Rating rating) {

    }

    @Override
    @Transactional
    public List <Rating> getAll(Integer id, Class tClass) {
        return null;
    }
}
