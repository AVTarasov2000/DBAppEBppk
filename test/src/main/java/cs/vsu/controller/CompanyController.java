package cs.vsu.controller;

import cs.vsu.dto.PublishingCompanyDTO;
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
public class CompanyController {
    @Autowired
    AppService service;
    @Autowired
    AppController appController;

    @RequestMapping(value = "/companys", method = {RequestMethod.POST})
    public ModelAndView companys(@ModelAttribute("user") UserDTO userDTO) {
        UserDTO user = service.getUser(userDTO);
        if(user == null){
            return appController.signIn();
        }
        return toCompanys(user);
    }

    @RequestMapping(value = "/addCompany", method = {RequestMethod.POST})
    public ModelAndView addCompany(@ModelAttribute("user") UserDTO userDTO,
                                   @ModelAttribute("companyName") String companyName) {
        UserDTO user = service.getUser(userDTO);
        PublishingCompanyDTO publishingCompanyDTO = new PublishingCompanyDTO(null, companyName);
        if(user == null){
            return appController.signIn();
        }
        service.addCompany(publishingCompanyDTO);
        return toCompanys(user);
    }

    @RequestMapping(value = "/updateCompany", method = {RequestMethod.POST})
    public ModelAndView updateCompany(@ModelAttribute("user") UserDTO userDTO,
                                      @ModelAttribute("companyName") String companyName,
                                      @ModelAttribute("companyId") Integer companyId) {
        UserDTO user = service.getUser(userDTO);
        PublishingCompanyDTO publishingCompanyDTO = new PublishingCompanyDTO(companyId, companyName);
        if(user == null){
            return appController.signIn();
        }
        service.updateCompany(publishingCompanyDTO);
        return toCompanys(user);
    }

    @RequestMapping(value = "/deleteCompany", method = {RequestMethod.POST})
    public ModelAndView deleteCompany(@ModelAttribute("user") UserDTO userDTO,
                                      @ModelAttribute("companyName") String companyName,
                                      @ModelAttribute("companyId") Integer companyId) {
        UserDTO user = service.getUser(userDTO);
        PublishingCompanyDTO publishingCompanyDTO = new PublishingCompanyDTO(companyId, companyName);
        if(user == null){
            return appController.signIn();
        }
        service.deleteCompany(publishingCompanyDTO);
        return toCompanys(user);
    }

    private ModelAndView toCompanys(UserDTO user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("companys");
        appController.setNavBarFields(modelAndView, user);
        List <PublishingCompanyDTO> companys = service.getAllCompanys();
        modelAndView.addObject("companys", companys);
        return modelAndView;
    }
}
