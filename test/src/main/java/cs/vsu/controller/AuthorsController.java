package cs.vsu.controller;

import cs.vsu.controller.AppController;
import cs.vsu.dto.AuthorDTO;
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
public class AuthorsController {

    @Autowired
    AppService service;
    @Autowired
    AppController appController;

    @RequestMapping(value = "/authors", method = {RequestMethod.POST})
    public ModelAndView authors(@ModelAttribute("user") UserDTO userDTO) {
        UserDTO user = service.getUser(userDTO);
        if(user == null){
            return appController.signIn();
        }
        return toAuthors(user);
    }

    public ModelAndView toAuthors(UserDTO user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("authors");
        appController.setNavBarFields(modelAndView, user);
        List <AuthorDTO> authors = service.getAllAuthors();
        modelAndView.addObject("authors", authors);
        return modelAndView;
    }

    @RequestMapping(value = "/addAuthor", method = {RequestMethod.POST})
    public ModelAndView addAuthor(@ModelAttribute("user") UserDTO userDTO,
                                  @ModelAttribute("authorName") String authorName) {
        UserDTO user = service.getUser(userDTO);
        AuthorDTO authorDTO = new AuthorDTO(null, authorName);
        if(user == null){
            return appController.signIn();
        }
        service.addAuthor(authorDTO);
        return toAuthors(user);
    }

    @RequestMapping(value = "/updateAuthor", method = {RequestMethod.POST})
    public ModelAndView updateAuthor(@ModelAttribute("user") UserDTO userDTO,
                                     @ModelAttribute("authorName") String authorName,
                                     @ModelAttribute("authorId") Integer authorId) {
        UserDTO user = service.getUser(userDTO);
        AuthorDTO authorDTO = new AuthorDTO(authorId, authorName);
        if(user == null){
            return appController.signIn();
        }
        service.updateAuthor(authorDTO);
        return toAuthors(user);

    }

    @RequestMapping(value = "/deleteAuthor", method = {RequestMethod.POST})
    public ModelAndView deleteAuthor(@ModelAttribute("user") UserDTO userDTO,
                                     @ModelAttribute("authorName") String authorName,
                                     @ModelAttribute("authorId") Integer authorId) {
        UserDTO user = service.getUser(userDTO);
        AuthorDTO authorDTO = new AuthorDTO(authorId, authorName);
        if(user == null){
            return appController.signIn();
        }
        service.deleteAuthor(authorDTO);
        return toAuthors(user);
    }
}
