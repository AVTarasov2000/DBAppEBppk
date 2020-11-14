package cs.vsu.controller;

import cs.vsu.dto.UserDTO;
import cs.vsu.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    AppService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView signIn() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        service.getAllAuthors();
        modelAndView.addObject("test", "test");
        return modelAndView;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ModelAndView signInCheck(@ModelAttribute("user") UserDTO userDTO) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("test", userDTO.getLogin());
        return modelAndView;
    }


    //setters---------------------------------------------------------------------
    @Autowired
    public void setService(AppService service) {
        this.service = service;
    }
}
