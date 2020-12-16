package cs.vsu.dao;

import cs.vsu.dto.BookDTO;
import cs.vsu.dto.MultipleBookSelectDTO;
import cs.vsu.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                        "order by -count(b.name)/(Select count(*) from \"LIBRARY_APP\".library.read_book rbb where rbb.book_id = b.id)\n" +
                        "fetch first 10 row only");
        List sqlRes = query.getResultList();
        List<Book> res = new ArrayList <>();
        int count = 0;
        for (Object row : sqlRes) {
            Object[] r = (Object[])row;
            Book b = new Book((Integer)r[0], (String)r[1], (Date)r[2], (String)r[3], (Integer)r[4], new HashSet <>(), new HashSet <>());
            b.setGenres(getBooksGenres(b));
            b.setAuthors(getBooksAuthors(b));
            res.add(b);
            count++;
            if (count==10)
                break;
        }

        return res;
    }

    @Override
    public List <Book> getBySelector(MultipleBookSelectDTO selectDTO) {
        Session session = sessionFactory.openSession();
        String authorJoins = "";
        String authorWheres = "";
        String authorTemp = "ba";
        for (Integer id:
             selectDTO.getAuthorIds()) {
            authorJoins += " JOIN \"LIBRARY_APP\".library.book_author "+authorTemp+" on b.id = "+authorTemp+".book_id \n";
            authorWheres += " And "+authorTemp+".author_id="+id.toString()+"\n";
            authorTemp += authorTemp;
        }

        String genreJoins = "";
        String genreWheres = "";
        String genreTemp = "bg";
        for (Integer id:
                selectDTO.getGenreIds()) {
            genreJoins += " JOIN \"LIBRARY_APP\".library.book_genre "+genreTemp+" on b.id = "+genreTemp+".book_id \n";
            genreWheres += " And "+genreTemp+".genre_id="+id.toString()+"\n";
            genreTemp += genreTemp;
        }
        String companyCheck = "";
        if(selectDTO.getBookCompanyId()!=null)
            companyCheck = "And b.company_id = :sCompany ";
        String nameCheck = " '1' = '1'";
        if(!selectDTO.getBookName().equals(""))
            nameCheck = " b.name=:sName ";
        
        Query query = session.createSQLQuery(
                "SELECT b.id, b.name, b.release_date, b.link_to_file, b.company_id from \"LIBRARY_APP\".library.book b\n" +
                        authorJoins+
                        genreJoins+
//                        "WHERE b.name=:sName" +
                        "WHERE"+ nameCheck +
                        " And b.release_date BETWEEN :sDateFrom And :sDateTo " +
//                        "And b.company_id = :sCompany " +
                        companyCheck+
                        authorWheres+
                        genreWheres
                        );
        if(!selectDTO.getBookName().equals(""))
            query.setParameter("sName", selectDTO.getBookName());
        query.setParameter("sDateFrom", selectDTO.getBookReleaseDateFrom());
        query.setParameter("sDateTo", selectDTO.getBookReleaseDateTo());
        if(selectDTO.getBookCompanyId()!=null)
            query.setParameter("sCompany", selectDTO.getBookCompanyId());

        List sqlRes = query.getResultList();
        List<Book> res = new ArrayList <>();
        int count = 0;
        for (Object row : sqlRes) {
            Object[] r = (Object[])row;
            Book b = new Book((Integer)r[0], (String)r[1], (Date)r[2], (String)r[3], (Integer)r[4], new HashSet <>(), new HashSet <>());
            b.setGenres(getBooksGenres(b));
            b.setAuthors(getBooksAuthors(b));
            res.add(b);
            count++;
            if (count==10)
                break;
        }

        return res;
    }

    public Set <Author> getBooksAuthors(Book book){
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery(
                "SELECT a.id, a.name from \"LIBRARY_APP\".library.author a\n" +
                        "join \"LIBRARY_APP\".library.book_author ba on a.id=ba.author_id\n" +
                        "Where ba.book_id = :bookId\n"
        );
        query.setParameter("bookId", book.getBookId());
        List sqlRes = query.getResultList();
        Set<Author> res = new HashSet <>();
        for (Object o :
                sqlRes) {
            Object[] row = (Object[]) o;
            res.add(new Author((Integer) row[0], (String) row[1], new HashSet <>()));
        }
        return res;
    }

    public Set <Genre> getBooksGenres(Book book){
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery(
                "SELECT g.id, g.name from \"LIBRARY_APP\".library.genre g\n" +
                        "join \"LIBRARY_APP\".library.book_genre bg on g.id=bg.genre_id\n" +
                        "Where bg.book_id = :bookId\n"
        );
        query.setParameter("bookId", book.getBookId());
        List sqlRes = query.getResultList();
        Set<Genre> res = new HashSet <>();
        for (Object o :
                sqlRes) {
            Object[] row = (Object[]) o;
            res.add(new Genre((Integer) row[0], (String) row[1], new HashSet <>()));
        }
        return res;
    }
}
