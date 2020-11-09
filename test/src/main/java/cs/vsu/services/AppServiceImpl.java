package cs.vsu.services;

import cs.vsu.dao.Dao;
import cs.vsu.dto.AuthorDTO;
import cs.vsu.models.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class AppServiceImpl implements AppService {

    private Dao<Author> authorDao;
    private Dao<Book> bookDao;
    private Dao<BookMark> bookMarkDao;
    private Dao<Genre> genreDao;
    private Dao<PublishingCompany> publishingCompanyDao;
    private Dao<Rating> ratingDao;
    private Dao<User> userDao;
    private Dao<UsersRating> usersRatingDao;

    @Override
    public List <AuthorDTO> getAllAuthors() {
        authorDao.getAll(Author.class);
        return null;
    }









    ///getters--------------------------------------------------------------------------------
    @Autowired
    public void setAuthorDao(Dao <Author> authorDao) {
        this.authorDao = authorDao;
    }

    @Autowired
    public void setBookDao(Dao <Book> bookDao) {
        this.bookDao = bookDao;
    }

    @Autowired
    public void setBookMarkDao(Dao <BookMark> bookMarkDao) {
        this.bookMarkDao = bookMarkDao;
    }

    @Autowired
    public void setGenreDao(Dao <Genre> genreDao) {
        this.genreDao = genreDao;
    }

    @Autowired
    public void setPublishingCompanyDao(Dao <PublishingCompany> publishingCompanyDao) {
        this.publishingCompanyDao = publishingCompanyDao;
    }

    @Autowired
    public void setRatingDao(Dao <Rating> ratingDao) {
        this.ratingDao = ratingDao;
    }

    @Autowired
    public void setUserDao(Dao <User> userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setUsersRatingDao(Dao <UsersRating> usersRatingDao) {
        this.usersRatingDao = usersRatingDao;
    }
}
