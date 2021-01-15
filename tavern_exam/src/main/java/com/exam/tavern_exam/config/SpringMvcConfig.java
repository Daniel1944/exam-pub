package com.exam.tavern_exam.config;

import com.exam.tavern_exam.dao.TavernDAO;
import com.exam.tavern_exam.dao.TavernDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.exam.tavern_exam")
public class SpringMvcConfig implements WebMvcConfigurer {

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/tavern");
        dataSource.setUsername("daniel");
        dataSource.setPassword("Passwor123/4");

        return dataSource;
    }

    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view /");
        resolver.setSuffix(".jsp");

        return resolver;
    }

    @Bean
    public TavernDAO getUserDAO(){
        return new TavernDAOImpl(getDataSource());
    }
}
