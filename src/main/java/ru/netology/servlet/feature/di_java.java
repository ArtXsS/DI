package ru.netology.servlet.feature;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.controller.PostController;
import ru.netology.repository.PostRepository;
import ru.netology.service.PostService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServlet;

@Configuration
public class AppConfig{
    @Bean
    public PostRepository postRepository() {
        return new PostRepository();
    }
    @Bean
    public PostService postService(PostRepository postRepository) {
        return new PostService(postRepository);
    }

    @Bean
    public PostController postController(PostService postService) {
        return new PostController(postService);
    }

}

public class di_java extends HttpServlet {
    private PostController controller;
    @Override
    public void init() {
        ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        controller = context.getBean(PostController.class);
    }
}
