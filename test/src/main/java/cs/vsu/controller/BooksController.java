package cs.vsu.controller;

import cs.vsu.dto.AuthorDTO;
import cs.vsu.dto.BookDTO;
import cs.vsu.dto.UserDTO;
import cs.vsu.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
        List <BookDTO> authors = service.getAllBooks();
        modelAndView.addObject("books", authors);
        return modelAndView;
    }

    @RequestMapping(value = "/addBook", method = {RequestMethod.POST})
    public ModelAndView addAuthor(@ModelAttribute("user") UserDTO userDTO,
                                  @ModelAttribute("book") BookDTO bookDTO) {
        UserDTO user = service.getUser(userDTO);
//        AuthorDTO authorDTO = new AuthorDTO(null, authorName);
        if(user == null){
            return appController.signIn();
        }
//        service.addAuthor(authorDTO);
        return toBooks(user);
    }

    @RequestMapping(value = "/updateBooks", method = {RequestMethod.POST})
    public ModelAndView updateAuthor(@ModelAttribute("user") UserDTO userDTO,
                                     @ModelAttribute("booksName") String authorName,
                                     @ModelAttribute("booksId") Integer authorId) {
        UserDTO user = service.getUser(userDTO);
        AuthorDTO authorDTO = new AuthorDTO(authorId, authorName);
        if(user == null){
            return appController.signIn();
        }
        service.updateAuthor(authorDTO);
        return toBooks(user);

    }

    @RequestMapping(value = "/deleteBooks", method = {RequestMethod.POST})
    public ModelAndView deleteAuthor(@ModelAttribute("user") UserDTO userDTO,
                                     @ModelAttribute("booksName") String authorName,
                                     @ModelAttribute("booksId") Integer authorId) {
        UserDTO user = service.getUser(userDTO);
        AuthorDTO authorDTO = new AuthorDTO(authorId, authorName);
        if(user == null){
            return appController.signIn();
        }
        service.deleteAuthor(authorDTO);
        return toBooks(user);
    }
}
