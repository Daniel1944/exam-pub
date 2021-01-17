package com.exam.tavern_exam.dao;

import com.exam.tavern_exam.model.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TavernDAOImpl implements TavernDAO {

    private JdbcTemplate jdbcTemplate;

    public TavernDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User getUserById(Integer id) {
        String sql = "SELECT * FROM tavern.user WHERE user_id =" + id;
        ResultSetExtractor<User> extractor = new ResultSetExtractor<User>() {
            @Override
            public User extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    String name = rs.getString("name");
                    boolean isAdult = rs.getBoolean("is_adult");
                    boolean isActive = rs.getBoolean("is_active");
                    double money = rs.getDouble("money");

                    return new User(id, name, isAdult, isActive, money);
                }
                return null;
            }
        };
        return jdbcTemplate.query(sql, extractor);
    }

    @Override
    public List<UserOrders> getUserOrder(Integer id) {
        String sql = "SELECT order.id,drink_menu.product_name, order.amount, drink_menu.price * order.amount AS total_price " +
                "FROM tavern.order " +
                "INNER JOIN tavern.drink_menu ON order.drink_id = drink_menu.drink_id " +
                "WHERE order.user_id = " + id;

        RowMapper<UserOrders> rm = new RowMapper<UserOrders>() {
            @Override
            public UserOrders mapRow(ResultSet rs, int rowNum) throws SQLException {
                int id = rs.getInt("id");
                String productName = rs.getString("product_name");
                int amount = rs.getInt("amount");
                double price = rs.getDouble("total_price");

                return new UserOrders(id, productName, amount, price);

            }
        };

        return jdbcTemplate.query(sql, rm);

    }

    @Override
    public List<User> getUser() {
        String sql = "SELECT * FROM tavern.user;";

        RowMapper<User> rm = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                int id = rs.getInt("user_id");
                String name = rs.getString("name");
                boolean isAdult = rs.getBoolean("is_adult");
                boolean isActive = rs.getBoolean("is_active");
                double money = rs.getDouble("money");

                return new User(id, name, isAdult, isActive, money);

            }
        };

        return jdbcTemplate.query(sql, rm);
    }

    @Override
    public List<DrinkMenu> getMenu() {
        String sql = "SELECT * FROM tavern.drink_menu";

        RowMapper<DrinkMenu> rm = new RowMapper<DrinkMenu>() {
            @Override
            public DrinkMenu mapRow(ResultSet rs, int rowNum) throws SQLException {
                int id = rs.getInt("drink_id");
                String productName = rs.getString("product_name");
                boolean isForAdult = rs.getBoolean("is_for_adult");
                double price = rs.getDouble("price");

                return new DrinkMenu(id, productName, price, isForAdult);

            }
        };
        return jdbcTemplate.query(sql, rm);
    }

    @Override
    public List<Summary> getSummaryAll() {
        String sql = "SELECT drink_menu.product_name, SUM(order.amount) AS summaryAmmount, drink_menu.price, SUM(order.amount) * drink_menu.price AS summaryPrice " +
                "FROM tavern.order  " +
                "INNER JOIN tavern.drink_menu ON order.drink_id = drink_menu.drink_id " +
                "WHERE order.drink_id = drink_menu.drink_id " +
                "GROUP BY order.drink_id;";

        RowMapper<Summary> rm = new RowMapper<Summary>() {
            @Override
            public Summary mapRow(ResultSet rs, int rowNum) throws SQLException {
                String productName = rs.getString("product_name");
                int summaryAmount = rs.getInt("summaryAmmount");
                double price = rs.getDouble("price");
                double summaryPrice = rs.getDouble("summaryPrice");

                return new Summary(productName, summaryAmount, price, summaryPrice);

            }
        };

        return jdbcTemplate.query(sql, rm);
    }

    @Override
    public List<Summary> getSummaryProduct() {
        String sql = "SELECT order.user_id, order.amount, drink_menu.price " +
                "FROM tavern.order " +
                "INNER JOIN tavern.drink_menu ON order.drink_id = drink_menu.drink_id";

        RowMapper<Summary> rm = new RowMapper<Summary>() {
            @Override
            public Summary mapRow(ResultSet rs, int rowNum) throws SQLException {
                int userId = rs.getInt("user_id");
                int amount = rs.getInt("amount");
                double price = rs.getDouble("price");

                return new Summary(userId, amount, price);

            }
        };
        return jdbcTemplate.query(sql, rm);
    }

    @Override
    public List<Summary> getSummaryUser() {
        String sql = "SELECT order.user_id, drink_menu.product_name, drink_menu.price" +
                " FROM tavern.order" +
                " INNER JOIN tavern.drink_menu ON order.drink_id = drink_menu.drink_id" +
                " INNER JOIN tavern.user ON order.user_id = user.user_id";

        RowMapper<Summary> rm = new RowMapper<Summary>() {
            @Override
            public Summary mapRow(ResultSet rs, int rowNum) throws SQLException {
                int userId = rs.getInt("user_id");
                String product = rs.getString("product_name");
                double price = rs.getDouble("price");

                return new Summary(userId, product, price);

            }
        };
        return jdbcTemplate.query(sql, rm);
    }

    @Override
    public Validation validation(User user, DrinkMenu menu) {
        String sql = "SELECT drink_menu.drink_id, drink_menu.price, drink_menu.is_for_adult, user.user_id, user.money, user.is_adult" +
                " FROM tavern.drink_menu" +
                " CROSS JOIN tavern.user" +
                " WHERE drink_menu.drink_id = " + menu.getId() +" AND user.user_id = " + user.getId();
        ResultSetExtractor<Validation> extractor = new ResultSetExtractor<Validation>() {
            @Override
            public Validation extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next() & user.getId() > 0) {
                    int drinkId = rs.getInt("drink_id");
                    double price = rs.getDouble("price");
                    boolean isForAdult = rs.getBoolean("is_for_adult");
                    int userId = rs.getInt("user_id");
                    double money = rs.getDouble("money");
                    boolean isAdult = rs.getBoolean("is_adult");
                    String answer = "";
                    if (price <= money & isAdult || !isForAdult & price <= money){
                        answer = "The guest can order a drink";
                    }else if(price > money){
                        answer= "The guest cannot order because he does not have enough money";
                    } else {
                        answer = "The guest cannot order because he is not an adult";
                    }

                    return new Validation(userId, drinkId, price, answer);
                }
                return null;
            }
        };
        return jdbcTemplate.query(sql, extractor);
    }


}
