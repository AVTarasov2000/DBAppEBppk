package cs.vsu.controller;

import cs.vsu.dto.GenreDTO;
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
public class GenreController {
    @Autowired
    AppService service;
    @Autowired
    AppController appController;

    @RequestMapping(value = "/genres", method = {RequestMethod.POST})
    public ModelAndView genres(@ModelAttribute("user") UserDTO userDTO) {
        UserDTO user = service.getUser(userDTO);
        if(user == null){
            return appController.signIn();
        }
        return toGenres(user);
    }

    @RequestMapping(value = "/addGenre", method = {RequestMethod.POST})
    public ModelAndView addGenre(@ModelAttribute("user") UserDTO userDTO,
                                 @ModelAttribute("genreName") String genreName) {
        UserDTO user = service.getUser(userDTO);
        GenreDTO genreDTO = new GenreDTO(null, genreName);
        if(user == null){
            return appController.signIn();
        }
        service.addGenre(genreDTO);
        return toGenres(user);
    }

    @RequestMapping(value = "/updateGenre", method = {RequestMethod.POST})
    public ModelAndView updateGenre(@ModelAttribute("user") UserDTO userDTO,
                                    @ModelAttribute("genreName") String genreName,
                                    @ModelAttribute("genreId") Integer genreId) {
        UserDTO user = service.getUser(userDTO);
        GenreDTO genreDTO = new GenreDTO(genreId,genreName);
        if(user == null){
            return appController.signIn();
        }
        service.updateGenre(genreDTO);
        return toGenres(user);

    }

    @RequestMapping(value = "/deleteGenre", method = {RequestMethod.POST})
    public ModelAndView deleteGenre(@ModelAttribute("user") UserDTO userDTO,
                                    @ModelAttribute("genreName") String genreName,
                                    @ModelAttribute("genreId") Integer genreId) {
        UserDTO user = service.getUser(userDTO);
        GenreDTO genreDTO = new GenreDTO(genreId,genreName);
        if(user == null){
            return appController.signIn();
        }
        service.deleteGenre(genreDTO);
        return toGenres(user);
    }

    private ModelAndView toGenres(UserDTO user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("genres");
        appController.setNavBarFields(modelAndView, user);
        List <GenreDTO> genres = service.getAllGenres();
        modelAndView.addObject("genres", genres);
        return modelAndView;
    }
}
