package cs.vsu.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import cs.vsu.dto.*;
import cs.vsu.models.Book;
import cs.vsu.services.AppService;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.HashSet;
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

    @RequestMapping(value = "/selectBooks", method = {RequestMethod.POST})
    public ModelAndView selectBooks(
            @ModelAttribute("user") UserDTO userDTO,
            @ModelAttribute("selector") MultipleBookSelectDTO selectDTO,
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
                selectDTO.getAuthorIds().add(Integer.parseInt(author[0]));
            }
        }
        if(!genreStr.equals("")) {
            String[] genres = genreStr.split(",");
            for (String gen : genres) {
                String[] genre = gen.split(":");
                selectDTO.getGenreIds().add(Integer.parseInt(genre[0]));
            }
        }
        if(!companyStr.equals("")) {
            String[] company = companyStr.split(":");
            selectDTO.setBookCompanyId(Integer.parseInt(company[0]));
        }
        List<BookDTO> selectedBooks = service.getBySelector(selectDTO);
        return toChoosingPage(user, selectedBooks);
    }

    @RequestMapping(value = "/tenBest", method = {RequestMethod.POST})
    public ModelAndView mainWithTenBest(@ModelAttribute("user") UserDTO userDTO) {
        UserDTO user = service.getUser(userDTO);
        if(user == null){
            return appController.signIn();
        }
        List<BookDTO> tenBestBooks = service.getTenBestBooks();
        return toChoosingPage(userDTO, tenBestBooks);
    }

    public ModelAndView toChoosingPage(UserDTO userDTO){
        List <BookDTO> books = service.getAllBooks();
        return toChoosingPage(userDTO, books);
    }

    public ModelAndView toChoosingPage(UserDTO user, List<BookDTO> books){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("chooseBook");
        appController.setNavBarFields(modelAndView, user);
//        List <BookDTO> books = service.getAllBooks();
        List <AuthorDTO> authors = service.getAllAuthors();
        List <PublishingCompanyDTO> companys = service.getAllCompanys();
        List<GenreDTO> genres = service.getAllGenres();
        modelAndView.addObject("books", books);
        modelAndView.addObject("authors", authors);
        modelAndView.addObject("companys", companys);
        modelAndView.addObject("genres", genres);
        return modelAndView;
    }

    @SneakyThrows
    @RequestMapping(value = "/addToUserBooks", method = {RequestMethod.POST})
    public void addToUserBooks(@RequestBody String str) {
        JSONObject jObject = new JSONObject(str);

        System.out.println(str);
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(jObject.getString("login"));
        userDTO.setPassword(jObject.getString("password"));

        UserDTO user = service.getUser(userDTO);
        if(user == null){
            return;
        }

        BookMarkDTO bookMarkDTO = new BookMarkDTO();
        bookMarkDTO.setBookId(Integer.parseInt(jObject.getString("bookId")));
        bookMarkDTO.setPage(Integer.parseInt(jObject.getString("page")));
        bookMarkDTO.setUserId(user.getId());
        service.addBookMark(bookMarkDTO);

    }

}
