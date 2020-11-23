package cs.vsu.controller;

import cs.vsu.dto.*;
import cs.vsu.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;

@Controller
public class BooksController {

    @Autowired
    AppService service;
    @Autowired
    AppController appController;

    @RequestMapping(value = "/books", method = {RequestMethod.POST})
    public ModelAndView authors(@ModelAttribute("user") UserDTO userDTO) {
        UserDTO user = service.getUser(userDTO);
        if(user == null){
            return appController.signIn();
        }
        return toBooks(user);
    }

    public ModelAndView toBooks(UserDTO user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("books");
        appController.setNavBarFields(modelAndView, user);
        List <BookDTO> books = service.getAllBooks();
        List <AuthorDTO> authors = service.getAllAuthors();
        List <PublishingCompanyDTO> companys = service.getAllCompanys();
        List<GenreDTO> genres = service.getAllGenres();
        modelAndView.addObject("books", books);
        modelAndView.addObject("authors", authors);
        modelAndView.addObject("companys", companys);
        modelAndView.addObject("genres", genres);
        return modelAndView;
    }

    @RequestMapping(value = "/addBook", method = {RequestMethod.POST})
    public ModelAndView addAuthor(@ModelAttribute("user") UserDTO userDTO,
                                  @ModelAttribute("book") BookDTO bookDTO,
                                  @ModelAttribute("company") String companyStr,
                                  @ModelAttribute("author") String authorStr,
                                  @ModelAttribute("genre") String genreStr
    ) {
        UserDTO user = service.getUser(userDTO);
        if(user == null){
            return appController.signIn();
        }
        if(!authorStr.equals("")) {
            String[] authors = authorStr.split(",");
            for (String auth : authors) {
                String[] author = auth.split(":");
                bookDTO.getAuthors().add(new AuthorDTO(Integer.parseInt(author[0]), author[1], new HashSet <>()));
            }
        }
        if(!genreStr.equals("")) {
            String[] genres = genreStr.split(",");
            for (String gen : genres) {
                String[] genre = gen.split(":");
                bookDTO.getGenres().add(new GenreDTO(Integer.parseInt(genre[0]), genre[1], new HashSet <>()));
            }
        }
        if(!companyStr.equals("")) {
            String[] company = companyStr.split(":");
//            bookDTO.setPublishingCompany(new PublishingCompanyDTO(Integer.parseInt(company[0]), company[1], new HashSet <>()));
            bookDTO.setBookCompanyId(Integer.parseInt(company[0]));
        }
        service.addBook(bookDTO);
        return toBooks(user);
    }

    @RequestMapping(value = "/updateBook", method = {RequestMethod.POST})
    public ModelAndView updateAuthor(@ModelAttribute("user") UserDTO userDTO,
                                     @ModelAttribute("book") BookDTO bookDTO,
                                     @ModelAttribute("company") String companyStr,
                                     @ModelAttribute("author") String authorStr,
                                     @ModelAttribute("genre") String genreStr) {
        UserDTO user = service.getUser(userDTO);
        if(user == null){
            return appController.signIn();
        }

        if(!authorStr.equals("")) {
            String[] authors = authorStr.split(",");
            for (String auth : authors) {
                String[] author = auth.split(":");
                bookDTO.getAuthors().add(new AuthorDTO(Integer.parseInt(author[0]), author[1], new HashSet <>()));
            }
        }

        if(!genreStr.equals("")) {
            String[] genres = genreStr.split(",");
            for (String gen : genres) {
                String[] genre = gen.split(":");
                bookDTO.getGenres().add(new GenreDTO(Integer.parseInt(genre[0]), genre[1], new HashSet <>()));
            }
        }

        if(!companyStr.equals("")) {
            String[] company = companyStr.split(":");
            bookDTO.setBookCompanyId(Integer.parseInt(company[0]));
        }
        service.updateBook(bookDTO);
        return toBooks(user);

    }

    @RequestMapping(value = "/deleteBook", method = {RequestMethod.POST})
    public ModelAndView deleteAuthor(@ModelAttribute("user") UserDTO userDTO,
                                     @ModelAttribute("book") BookDTO bookDTO
    ) {
        UserDTO user = service.getUser(userDTO);
        if(user == null){
            return appController.signIn();
        }
        service.deleteBook(bookDTO);
        return toBooks(user);
    }

   @RequestMapping(value = "/deleteBookAuthor", method = {RequestMethod.POST})
    public ModelAndView deleteBookAuthor(@ModelAttribute("user") UserDTO userDTO,
                                         @ModelAttribute("bookId") String bookId,
                                         @ModelAttribute("authorId") String authorId
    ) {
        UserDTO user = service.getUser(userDTO);
        if(user == null){
            return appController.signIn();
        }
//        service.deleteBookAuthor(Integer.parseInt(bookId), Integer.parseInt(authorId));
        return toBooks(user);
    }

    @RequestMapping(value = "/addBookAuthor", method = {RequestMethod.POST})
    public ModelAndView addBookAuthor(@ModelAttribute("user") UserDTO userDTO,
                                      @ModelAttribute("bookId") String bookId,
                                      @ModelAttribute("authorId") String authorId
    ) {
        UserDTO user = service.getUser(userDTO);
        if(user == null){
            return appController.signIn();
        }
//        service.addBookAuthor(Integer.parseInt(bookId), Integer.parseInt(authorId));
        return toBooks(user);
    }

    @RequestMapping(value = "/deleteBookGenre", method = {RequestMethod.POST})
    public ModelAndView deleteBookGenre(@ModelAttribute("user") UserDTO userDTO,
                                        @ModelAttribute("bookId") String bookId,
                                        @ModelAttribute("genreId") String genreId
    ) {
        UserDTO user = service.getUser(userDTO);
        if(user == null){
            return appController.signIn();
        }
//        service.deleteBookGenre(Integer.parseInt(bookId), Integer.parseInt(genreId));
        return toBooks(user);
    }

    @RequestMapping(value = "/addBookGenre", method = {RequestMethod.POST})
    public ModelAndView addBookGenre(@ModelAttribute("user") UserDTO userDTO,
                                     @ModelAttribute("bookId") String bookId,
                                     @ModelAttribute("genreId") String genreId
    ) {
        UserDTO user = service.getUser(userDTO);
        if(user == null){
            return appController.signIn();
        }
//        service.addBookGenre(Integer.parseInt(bookId), Integer.parseInt(genreId));
        return toBooks(user);
    }
}
