package cs.vsu.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs.vsu.dto.*;
import cs.vsu.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ChooseBookController {
    @Autowired
    AppService service;
    @Autowired
    AppController appController;

    @RequestMapping(value = "/choosingBookPage", method = {RequestMethod.POST})
    public ModelAndView choosingBookPage(@ModelAttribute("user") UserDTO userDTO) {
        UserDTO user = service.getUser(userDTO);
        if(user == null){
            return appController.signIn();
        }
        return toChoosingPage(user);
    }

    public ModelAndView toChoosingPage(UserDTO user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("chooseBook");
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

    @RequestMapping(value = "/addToUserBooks", method = {RequestMethod.POST})
    public void addToUserBooks(@RequestBody String search) {
        System.out.println(search);
        Map <String,String> myMap = new HashMap <String, String>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            myMap = objectMapper.readValue(search, HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("Map is: "+myMap);

//        myMap = objectMapper.readValue(mapData, new TypeReference<HashMap<String,String>>() {});
//        System.out.println("Map using TypeReference: "+myMap);
    }

}
