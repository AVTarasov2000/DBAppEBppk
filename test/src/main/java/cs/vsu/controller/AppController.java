package cs.vsu.controller;

import cs.vsu.dto.*;
import cs.vsu.models.Genre;
import cs.vsu.models.PublishingCompany;
import cs.vsu.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Set;

@Controller
public class AppController {

    AppService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView signIn() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("alert", false);
        return modelAndView;
    }

    @RequestMapping(value = "/signin", method = {RequestMethod.POST})
    public ModelAndView signInCheck(@ModelAttribute("user") UserDTO userDTO) {
        return toMain(userDTO);
    }

    @RequestMapping(value = "/authors", method = {RequestMethod.POST})
    public ModelAndView authors(@ModelAttribute("user") UserDTO userDTO) {
        UserDTO user = service.getUser(userDTO);
        if(user == null){
            return signIn();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("authors");
        setNavBarFields(modelAndView, user);
        List<AuthorDTO> authors = service.getAllAuthors();
        modelAndView.addObject("authors", authors);
        return modelAndView;
    }

    @RequestMapping(value = "/genres", method = {RequestMethod.POST})
    public ModelAndView genres(@ModelAttribute("user") UserDTO userDTO) {
        UserDTO user = service.getUser(userDTO);
        if(user == null){
            return signIn();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("genres");
        setNavBarFields(modelAndView, user);
        List<GenreDTO> genres = service.getAllGenres();
        modelAndView.addObject("genres", genres);
        return modelAndView;
    }

    @RequestMapping(value = "/companys", method = {RequestMethod.POST})
    public ModelAndView companys(@ModelAttribute("user") UserDTO userDTO) {
        UserDTO user = service.getUser(userDTO);
        if(user == null){
            return signIn();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("companys");
        setNavBarFields(modelAndView, user);
        List<PublishingCompanyDTO> companys = service.getAllCompanys();
        modelAndView.addObject("companys", companys);
        return modelAndView;
    }

    @RequestMapping(value = "/addAuthor", method = {RequestMethod.POST})
    public ModelAndView addAuthor(@ModelAttribute("user") UserDTO userDTO,
                                  @ModelAttribute("authorName") String authorName) {
        UserDTO user = service.getUser(userDTO);
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setName(authorName);
        if(user == null){
            return signIn();
        }
        service.addAuthor(authorDTO);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("authors");
        setNavBarFields(modelAndView, user);
        List<AuthorDTO> authors = service.getAllAuthors();
        modelAndView.addObject("authors", authors);
        return modelAndView;
    }

    @RequestMapping(value = "/updateAuthor", method = {RequestMethod.POST})
    public ModelAndView updateAuthor(@ModelAttribute("user") UserDTO userDTO,
                                     @ModelAttribute("authorName") String authorName,
                                     @ModelAttribute("authorId") Integer authorId) {
        UserDTO user = service.getUser(userDTO);
        AuthorDTO authorDTO = new AuthorDTO(authorId, authorName);
        if(user == null){
            return signIn();
        }
        service.updateAuthor(authorDTO);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("authors");
        setNavBarFields(modelAndView, user);
        List<AuthorDTO> authors = service.getAllAuthors();
        modelAndView.addObject("authors", authors);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteAuthor", method = {RequestMethod.POST})
    public ModelAndView deleteAuthor(@ModelAttribute("user") UserDTO userDTO,
                                     @ModelAttribute("authorName") String authorName,
                                     @ModelAttribute("authorId") Integer authorId) {
        UserDTO user = service.getUser(userDTO);
        AuthorDTO authorDTO = new AuthorDTO(authorId, authorName);
        if(user == null){
            return signIn();
        }
        service.deleteAuthor(authorDTO);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("authors");
        setNavBarFields(modelAndView, user);
        List<AuthorDTO> authors = service.getAllAuthors();
        modelAndView.addObject("authors", authors);
        return modelAndView;
    }


    private ModelAndView toMain(UserDTO userDTO){
        UserDTO user = service.getUser(userDTO);
        ModelAndView modelAndView = new ModelAndView();
        if(user != null) {
            List <BookDTO> books = service.getAllBooks(user);
//            Set <BookDTO> books = user.getBooks();

            modelAndView.setViewName("main");
            setNavBarFields(modelAndView, user);
            modelAndView.addObject("books", books);

            return modelAndView;
        } else {
            return signInPage(modelAndView);
        }
    }

    private void setNavBarFields(ModelAndView modelAndView, UserDTO user){
        modelAndView.addObject("name", user.getName());
        modelAndView.addObject("login", user.getLogin());
        modelAndView.addObject("password", user.getPassword());
    }

    private ModelAndView signInPage(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        modelAndView.addObject("alert", true);
        modelAndView.addObject("warning", "there is no user with that login");
        return modelAndView;
    }


    //setters---------------------------------------------------------------------
    @Autowired
    public void setService(AppService service) {
        this.service = service;
    }
}
