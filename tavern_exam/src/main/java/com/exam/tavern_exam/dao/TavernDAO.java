package com.exam.tavern_exam.dao;

import com.exam.tavern_exam.model.*;

import java.util.List;

public interface TavernDAO {
    public User getUserById(Integer id);
    public List<UserOrders> getUserOrder(Integer id);
    public List<User> getUser();
    public List<DrinkMenu> getMenu();
    public List<Summary> getSummaryAll();
    public List<Summary> getSummaryProduct();
    public List<Summary> getSummaryUser();
    public Validation validation(User user, DrinkMenu drinkMenu);

}
