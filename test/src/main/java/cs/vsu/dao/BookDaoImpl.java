package cs.vsu.dao;

import cs.vsu.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
    public List <Book> getUsersBooks() {
        Session session = sessionFactory.openSession();
        Query <Book> query = session.createQuery("FROM Book");
        List <Book> res = query.getResultList();
        session.close();
        return res;
    }

    @Override
    public void addBook(Book book) {
        Session session = sessionFactory.openSession();
        book.getPublishingCompany().getBooks().add(book);
        for (Genre genre : book.getGenres()) {
            genre.getBooks().add(book);
        }
        for (Author author : book.getAuthors()) {
            author.getBooks().add(book);
        }
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();


    }
}
