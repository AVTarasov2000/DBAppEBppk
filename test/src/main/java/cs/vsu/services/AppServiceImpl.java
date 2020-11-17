package cs.vsu.services;

import cs.vsu.dao.BookDao;
import cs.vsu.dao.Dao;
import cs.vsu.dao.UserDao;
import cs.vsu.dto.*;
import cs.vsu.models.*;
import cs.vsu.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    private Dao<Author> authorDao;
//    private Dao<Book> bookDao;
    private Dao<Genre> genreDao;
    private Dao<PublishingCompany> publishingCompanyDao;
    private Dao<Rating> ratingDao;
    private UserDao userDao;
    private BookDao bookDao;
    private Dao<UsersRating> usersRatingDao;
    private Converter converter;

    @Override
    public boolean isExist(UserDTO user) {
        return userDao.checkUser((User) converter.convert(user));
    }

    public void addAuthor(AuthorDTO authorDTO){
        authorDao.save((Author) converter.convert(authorDTO));
    }

    public void deleteAuthor(AuthorDTO authorDTO){
        authorDao.delete((Author) converter.convert(authorDTO));
    }

    public void updateAuthor(AuthorDTO authorDTO){
        authorDao.update((Author) converter.convert(authorDTO));
    }

    @Override
    public UserDTO getUser(UserDTO user) {
        User user1 = userDao.getUser((User) converter.convert(user));
        if (user1 == null){
            return null;
        }
        else {
            return (UserDTO) converter.convert(user1);
        }
    }

    @Override
    public List <AuthorDTO> getAllAuthors() {
        List<AuthorDTO> res = new ArrayList <>();
        authorDao.getAll(Author.class).forEach( a -> res.add((AuthorDTO) converter.convert(a)));
        return res;
    }

    @Override
    public List <GenreDTO> getAllGenres() {
        List<GenreDTO> res = new ArrayList <>();
        genreDao.getAll(Genre.class).forEach( a -> res.add((GenreDTO) converter.convert(a)));
        return res;
    }

    @Override
    public List <PublishingCompanyDTO> getAllCompanys() {
        List<PublishingCompanyDTO> res = new ArrayList <>();
        publishingCompanyDao.getAll(PublishingCompany.class).forEach( a -> res.add((PublishingCompanyDTO) converter.convert(a)));
        return res;
    }

    @Override
    public List <BookDTO> getAllBooks(UserDTO user) {
        List<BookDTO> res = new ArrayList <>();
        List<Book> lst = bookDao.getUsersBooks((User) converter.convert(user));
        lst.forEach( a -> res.add((BookDTO) converter.convert(a)));
//        bookMarkDao.getAll(BookMark.class).forEach( a -> res.add((BookMarkDTO) converter.convert(a)));
        return res;
    }

    ///setters--------------------------------------------------------------------------------
    @Autowired
    public void setConverter(Converter converter) {
        this.converter = converter;
    }
    @Autowired
    public void setAuthorDao(Dao <Author> authorDao) {
        this.authorDao = authorDao;
    }

//    @Autowired
//    public void setBookDao(Dao <Book> bookDao) {
//        this.bookDao = bookDao;
//    }

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
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
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setUsersRatingDao(Dao <UsersRating> usersRatingDao) {
        this.usersRatingDao = usersRatingDao;
    }
}
