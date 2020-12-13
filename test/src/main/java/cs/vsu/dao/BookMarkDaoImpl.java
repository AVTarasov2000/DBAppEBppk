package cs.vsu.dao;

import cs.vsu.models.Book;
import cs.vsu.models.BookMark;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookMarkDaoImpl implements BookMarkDao{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    @Override
    public void removeNotById(BookMark bookMark) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("DELETE from \"LIBRARY_APP\".library.book_mark bm where bm.user_id = :userId and bm.book_id = :bookId");
        query.setParameter("userId", bookMark.getUserId());
        query.setParameter("bookId", bookMark.getBookId());
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}
