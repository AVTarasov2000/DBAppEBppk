package cs.vsu.controller;

import cs.vsu.dto.*;
import cs.vsu.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
        return toMain(userDTO, null);
    }

    @RequestMapping(value = "/tenBest", method = {RequestMethod.POST})
    public ModelAndView mainWithTenBest(@ModelAttribute("user") UserDTO userDTO) {
        Set<BookDTO> tenBestBooks = service.getTenBestBooks();
        return toMain(userDTO, tenBestBooks);
    }


    public ModelAndView toAuthors(UserDTO user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("authors");
        setNavBarFields(modelAndView, user);
        List<AuthorDTO> authors = service.getAllAuthors();
        modelAndView.addObject("authors", authors);
        return modelAndView;
    }


    private ModelAndView toMain(UserDTO userDTO, Set<BookDTO> viewBooks){
        UserDTO user = service.getUser(userDTO);
        ModelAndView modelAndView = new ModelAndView();
        if(user != null) {
            Set <BookDTO> books;
            if(viewBooks==null)
                books = user.getBooks();
            else
                books=viewBooks;

            modelAndView.setViewName("main");
            setNavBarFields(modelAndView, user);
            modelAndView.addObject("books", books);

            return modelAndView;
        } else {
            return signInPage(modelAndView);
        }
    }

    void setNavBarFields(ModelAndView modelAndView, UserDTO user){
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
