package cs.vsu.dao;

import cs.vsu.models.Book;
import cs.vsu.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List <Book> getUsersBooks(User user) {
        Session session = sessionFactory.openSession();
        Query <Book> query = session.createQuery("FROM Book FETCH ALL PROPERTIES ");
//        query.setParameter("uId",user.getId());
        List <Book> res = query.getResultList();
        session.close();
        return res;

    }
}
