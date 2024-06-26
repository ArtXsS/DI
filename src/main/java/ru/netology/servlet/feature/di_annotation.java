package ru.netology.servlet.feature;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.netology.controller.PostController;

import javax.servlet.http.HttpServlet;

@Configuration
@ComponentScan("ru.netology")

public class di_annotation extends HttpServlet {
    @Autowired
    private PostController controller;
    @Override
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
