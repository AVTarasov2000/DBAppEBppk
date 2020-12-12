package cs.vsu.dao;

import cs.vsu.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.hql.internal.ast.SqlASTFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List <Book> getAllBooks() {
        Session session = sessionFactory.openSession();
        Query <Book> query = session.createQuery("FROM Book");
        List <Book> res = query.getResultList();
        session.close();
        return res;
    }

    @Override
    public void addBook(Book book) {
        Session session = sessionFactory.openSession();
//        book.getPublishingCompany().getBooks().add(book);
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

    @Override
    public String middleRating(Integer bookId) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(
                "SELECT r.name from UsersRating rb\n" +
                        "    join Rating r on rb.rating= r.id\n" +
                        "    where rb.bookId=:bookId \n" +
                        "    GROUP BY r.name\n" +
                        "    order by count(*)\n"
        );
        query.setParameter("bookId", bookId);
        List res = query.getResultList();
        if (res.size()>0) {
            return (String) query.getResultList().get(0);
        }
        else
            return "";
    }

    @Override
    public List <Book> getTenBestBooks() {
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery(
                "SELECT b.id, b.name, b.release_date, b.link_to_file, b.company_id from \"LIBRARY_APP\".library.book b\n" +
                        "join \"LIBRARY_APP\".library.read_book rb on b.id=rb.book_id\n" +
                        "Join \"LIBRARY_APP\".library.rating r on r.id = rb.rating\n" +
                        "Where r.rating = 'very good'\n" +
                        "group by b.name, b.id\n" +
                        "order by count(b.name)");
        List sqlRes = query.getResultList();
        List<Book> res = new ArrayList <>();
        for (Object row : sqlRes) {
            Object[] r = (Object[])row;
            Book b = new Book((Integer)r[0], (String)r[1], (Date)r[2], (String)r[3], (Integer)r[4], new HashSet <>(), new HashSet <>());
            res.add(b);
        }
        return res;
    }

}
