package cs.vsu.dao;

import cs.vsu.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class UserDao implements Dao<User>{

    SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public User findById(Integer id, Class tClass) {
        return null;
    }

    @Override
    @Transactional
    public void save(User user) {

    }

    @Override
    @Transactional
    public void delete(User user) {

    }

    @Override
    @Transactional
    public void update(User user) {

    }

    @Override
    @Transactional
    public List <User> getAll(Integer id, Class tClass) {
        return null;
    }
}
