package cs.vsu.dao;

import cs.vsu.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public boolean checkUser(User user) {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM User FETCH ALL PROPERTIES WHERE login=:login and password=:password");
        query.setParameter("login",user.getLogin());
        query.setParameter("password",user.getPassword());
        List <User> res = query.getResultList();
        session.close();
        return res.size()>0;
    }

    public User getUser(User user){
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM User FETCH ALL PROPERTIES WHERE login=:login and password=:password");
        query.setParameter("login",user.getLogin());
        query.setParameter("password",user.getPassword());
        List <User> res = query.getResultList();
        session.close();
        if (res.size()>0)
            return res.get(0);
        else
            return null;
    }
}
