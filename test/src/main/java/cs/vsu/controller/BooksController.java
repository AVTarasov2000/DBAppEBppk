package cs.vsu.controller;

import cs.vsu.dto.*;
import cs.vsu.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
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
        String[] author = authorStr.split(":");
        String[] genre = genreStr.split(":");
        String[] company = companyStr.split(":");
        bookDTO.getAuthors().add(new AuthorDTO(Integer.parseInt(author[0]),author[1],new HashSet <>()));
        bookDTO.getGenres().add(new GenreDTO(Integer.parseInt(genre[0]), genre[1], new HashSet<>()));
        bookDTO.setPublishingCompany(new PublishingCompanyDTO(Integer.parseInt(company[0]),company[1],new HashSet<>()));
        if(user == null){
            return appController.signIn();
        }
        bookDTO.setBookCompanyId(Integer.parseInt(company[0]));
        service.addBook(bookDTO);
        return toBooks(user);
    }

    @RequestMapping(value = "/updateBooks", method = {RequestMethod.POST})
    public ModelAndView updateAuthor(@ModelAttribute("user") UserDTO userDTO,
                                     @ModelAttribute("booksName") String authorName,
                                     @ModelAttribute("booksId") Integer authorId) {
        UserDTO user = service.getUser(userDTO);
//        AuthorDTO authorDTO = new AuthorDTO(authorId, authorName);
        if(user == null){
            return appController.signIn();
        }
//        service.updateAuthor(authorDTO);
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
}
