package cs.vsu.controller;

import cs.vsu.dto.BookDTO;
import cs.vsu.dto.UserDTO;
import cs.vsu.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        return toMain(userDTO);
    }

    @RequestMapping(value = "/main/{login}/{password}", method = {RequestMethod.GET})
    public ModelAndView goToMain(@PathVariable("login") String login, @PathVariable("password")String password) {
        UserDTO tmp = new UserDTO();
        tmp.setLogin(login);
        tmp.setPassword(password);
        return toMain(tmp);
    }







    private ModelAndView toMain(UserDTO userDTO){
        UserDTO user = service.getUser(userDTO);
        if(user != null) {
            List <BookDTO> books = service.getAllBooks(user);
//            Set <BookDTO> books = user.getBooks();

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("main");
            modelAndView.addObject("name", user.getName());
            modelAndView.addObject("login", user.getLogin());
            modelAndView.addObject("password", user.getPassword());
            modelAndView.addObject("books", books);

            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("index");
            modelAndView.addObject("alert", true);
            modelAndView.addObject("warning", "there is no user with that login");
            return modelAndView;
        }
    }



    //setters---------------------------------------------------------------------
    @Autowired
    public void setService(AppService service) {
        this.service = service;
    }
}
