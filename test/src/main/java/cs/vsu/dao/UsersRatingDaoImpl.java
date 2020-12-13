package cs.vsu.dao;

import cs.vsu.models.UsersRating;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRatingDaoImpl implements UsersRatingDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUsersRating(UsersRating usersRating) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("INSERT into \"LIBRARY_APP\".library.read_book(book_id, user_id, rating) VALUES (:bookId, :userId, :rating)");
        query.setParameter("userId", usersRating.getUserId());
        query.setParameter("bookId", usersRating.getBookId());
        query.setParameter("rating", usersRating.getRatingId());
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}
