package cs.vsu.services;

import cs.vsu.dao.*;
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


    private Dao<Book> simpleBookDao;
    private Dao<Genre> genreDao;
    private Dao<PublishingCompany> publishingCompanyDao;
    private Dao<Rating> ratingDao;
    private UserDao userDao;
    private BookDao bookDao;
    private Dao<UsersRating> simpleUsersRatingDao;
    private Dao<BookMark> simpleBookMarkDao;
    private BookMarkDao bookMarkDao;
    private UsersRatingDao usersRatingDao;
    private Converter converter;


    private Dao<User> simpleUserDao;

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



    public void addCompany(PublishingCompanyDTO publishingCompanyDTO){
        publishingCompanyDao.save((PublishingCompany) converter.convert(publishingCompanyDTO));
    }

    public void deleteCompany(PublishingCompanyDTO publishingCompanyDTO){
        publishingCompanyDao.delete((PublishingCompany) converter.convert(publishingCompanyDTO));
    }

    public void updateCompany(PublishingCompanyDTO publishingCompanyDTO){
        publishingCompanyDao.update((PublishingCompany) converter.convert(publishingCompanyDTO));
    }


    public void addBookMark(BookMarkDTO bookMarkDTO){
        simpleBookMarkDao.save((BookMark) converter.convert(bookMarkDTO));
    }

    @Override
    public void deleteBookMark(BookMarkDTO bookMarkDTO) {
        bookMarkDao.removeNotById((BookMark)converter.convert(bookMarkDTO));
    }

    @Override
    public void addUsersRating(UsersRatingDTO usersRatingDTO) {
        usersRatingDao.addUsersRating((UsersRating)converter.convert(usersRatingDTO));
    }

    @Override
    public List <RatingDTO> getAllRatings() {
        List<RatingDTO> res = new ArrayList <>();
        ratingDao.getAll(Rating.class).forEach(a->res.add((RatingDTO) converter.convert(a)));
        return res;
    }

    @Override
    public List <BookDTO> getTenBestBooks() {
        List<BookDTO> res = new ArrayList <>();
        bookDao.getTenBestBooks().forEach( a -> res.add((BookDTO) converter.convert(a)));
        res.forEach(o-> o.setPublishingCompany((PublishingCompanyDTO) converter.convert(publishingCompanyDao.findById(o.getBookCompanyId(), PublishingCompany.class))));
        res.forEach(o-> o.setMiddleRating(bookDao.middleRating(o.getBookId())));
        return res;
    }

    @Override
    public void addUser(UserDTO userDTO) {
        simpleUserDao.save((User) converter.convert(userDTO));
    }

    public void addGenre(GenreDTO genreDTO){
        genreDao.save((Genre) converter.convert(genreDTO));
    }

    public void deleteGenre(GenreDTO genreDTO){
        genreDao.delete((Genre) converter.convert(genreDTO));
    }

    public void updateGenre(GenreDTO genreDTO){
        genreDao.update((Genre) converter.convert(genreDTO));
    }

    @Override
    public void addBook(BookDTO bookDTO) {
        bookDao.addBook((Book) converter.convert(bookDTO));
    }

    @Override
    public void updateBook(BookDTO bookDTO) {
        simpleBookDao.update((Book) converter.convert(bookDTO));
    }

    public void deleteBook(BookDTO bookDTO){
        simpleBookDao.delete((Book) converter.convert(bookDTO));
    }

    @Override
    public UserDTO getUser(UserDTO user) {
        User user1 = userDao.getUser((User) converter.convert(user));
        if (user1 == null){
            return null;
        }
        else {
            UserDTO userDTO = (UserDTO) converter.convert(user1);
            userDTO.getBooks().forEach(o-> o.setPublishingCompany((PublishingCompanyDTO) converter.convert(publishingCompanyDao.findById(o.getBookCompanyId(), PublishingCompany.class))));
            userDTO.getBooks().forEach(o-> o.setMiddleRating(bookDao.middleRating(o.getBookId())));
            return userDTO;
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
    public List <BookDTO> getAllBooks() {
        List<BookDTO> res = new ArrayList <>();
        List<Book> lst = bookDao.getAllBooks();
        lst.forEach( a -> res.add((BookDTO) converter.convert(a)));
        res.forEach(o-> o.setPublishingCompany((PublishingCompanyDTO) converter.convert(publishingCompanyDao.findById(o.getBookCompanyId(), PublishingCompany.class))));
        res.forEach(o-> o.setMiddleRating(bookDao.middleRating(o.getBookId())));
//        bookMarkDao.getAll(BookMark.class).forEach( a -> res.add((BookMarkDTO) converter.convert(a)));
        return res;
    }



    ///setters--------------------------------------------------------------------------------
    @Autowired
    public void setSimpleBookDao(Dao <Book> simpleBookDao) {
        this.simpleBookDao = simpleBookDao;
    }

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
    public void setSimpleBookMarkDao(Dao <BookMark> simpleBookMarkDao) {
        this.simpleBookMarkDao = simpleBookMarkDao;
    }

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
    public void setSimpleUsersRatingDao(Dao <UsersRating> simpleUsersRatingDao) {
        this.simpleUsersRatingDao = simpleUsersRatingDao;
    }

    @Autowired
    public void setSimpleUserDao(Dao <User> simpleUserDao) {
        this.simpleUserDao = simpleUserDao;
    }

    @Autowired
    public void setBookMarkDao(BookMarkDao bookMarkDao) {
        this.bookMarkDao = bookMarkDao;
    }

    @Autowired
    public void setUsersRatingDao(UsersRatingDao usersRatingDao) {
        this.usersRatingDao = usersRatingDao;
    }
}
