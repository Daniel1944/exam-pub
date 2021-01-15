package com.exam.tavern_exam;

import com.exam.tavern_exam.dao.TavernDAO;
import com.exam.tavern_exam.dao.TavernDAOImpl;
import com.exam.tavern_exam.model.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TavernDAOTest {

    private DriverManagerDataSource dataSource;
    public TavernDAO tavernDAO;

    @BeforeEach
    public void setupBeforeEach() {

    }


    @Test
    public void testGetUserById() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/tavern");
        dataSource.setUsername("daniel");
        dataSource.setPassword("Password123/4");
        tavernDAO = new TavernDAOImpl(dataSource);
        Integer id = 1;
        User user = tavernDAO.getUserById(id);
        System.out.println(user);
        assertNotNull(user);
    }

    @Test
    public void testGetUserOrder() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/tavern");
        dataSource.setUsername("daniel");
        dataSource.setPassword("Password123/4");
        tavernDAO = new TavernDAOImpl(dataSource);
        Integer id = 1;
        List<UserOrders> userOrders = tavernDAO.getUserOrder(id);
        userOrders.forEach(System.out::println);
        assertNotNull(userOrders);
    }

    @Test
    public void testGetUser() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/tavern");
        dataSource.setUsername("daniel");
        dataSource.setPassword("Password123/4");

        tavernDAO = new TavernDAOImpl(dataSource);

        List<User> list = tavernDAO.getUser();
        list.forEach(System.out::println);

        assertFalse(list.isEmpty());
    }

    @Test
    public void testSummaryAll() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/tavern");
        dataSource.setUsername("daniel");
        dataSource.setPassword("Password123/4");

        tavernDAO = new TavernDAOImpl(dataSource);
        List<Summary> list = tavernDAO.getSummaryAll();
        list.forEach(System.out::println);

        assertFalse(list.isEmpty());
    }

    @Test
    public void testValidation() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/tavern");
        dataSource.setUsername("daniel");
        dataSource.setPassword("Password123/4");
        tavernDAO = new TavernDAOImpl(dataSource);
        User user = new User(4);
        DrinkMenu drinkMenu = new DrinkMenu(90);
        Validation val = tavernDAO.validation(user, drinkMenu);
        System.out.println(val);
    }
}
