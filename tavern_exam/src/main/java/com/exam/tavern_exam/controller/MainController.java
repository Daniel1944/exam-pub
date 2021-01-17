package com.exam.tavern_exam.controller;

import com.exam.tavern_exam.dao.TavernDAO;
import com.exam.tavern_exam.model.DrinkMenu;
import com.exam.tavern_exam.model.Summary;
import com.exam.tavern_exam.model.User;
import com.exam.tavern_exam.model.UserOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TavernDAO tavernDao;

    @RequestMapping(value = "/")
    public ModelAndView listUser(ModelAndView model) {
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView users(ModelAndView model) {
        List<User> listUser = tavernDao.getUser();
        model.addObject("usersList", listUser);
        model.setViewName("usersTable");
        return model;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView user(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = tavernDao.getUserById(userId);
        ModelAndView model = new ModelAndView();
        model.addObject("user", user);
        List<UserOrders> userOrders = tavernDao.getUserOrder(userId);
        model.addObject("orders", userOrders);
        model.setViewName("usersOrders");

        return model;
    }

    @RequestMapping(value = "/drink-menu", method = RequestMethod.GET)
    public ModelAndView drinkMenu(ModelAndView model) {
        List<DrinkMenu> drinkMenu = tavernDao.getMenu();
        model.addObject("drinkMenu", drinkMenu);
        model.setViewName("drinkMenu");
        return model;
    }

    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public ModelAndView valid(@ModelAttribute("validationAttribute") User user, DrinkMenu drinkMenu) {
        ModelAndView model = new ModelAndView();
        model.addObject("validation", tavernDao.validation(user, drinkMenu));
        model.setViewName("validation");
        return model;
    }

    @RequestMapping(value = "/summary/all", method = RequestMethod.GET)
    public ModelAndView summaryAll(ModelAndView model) {
        List<Summary> summaryAll = tavernDao.getSummaryAll();
        model.addObject("summaryAll", summaryAll);
        model.setViewName("summaryOfAll");
        return model;
    }

    @RequestMapping(value = "/summary/product", method = RequestMethod.GET)
    public ModelAndView summaryProduct(ModelAndView model) {
        List<Summary> summaryProduct = tavernDao.getSummaryProduct();
        model.addObject("summaryProduct", summaryProduct);
        model.setViewName("summaryOfProduct");
        return model;
    }

    @RequestMapping(value = "/summary/user", method = RequestMethod.GET)
    public ModelAndView summaryUser(ModelAndView model) {
        List<Summary> summaryUser = tavernDao.getSummaryUser();
        model.addObject("summaryUser", summaryUser);
        model.setViewName("summaryOfUser");
        return model;
    }

}
