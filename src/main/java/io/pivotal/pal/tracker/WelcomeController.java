package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public class WelcomeController {

    private String message;

    public WelcomeController(@Value("${WELCOME_MESSAGE: Hello!}") String pMessage){
        message = pMessage;
    }

    @GetMapping("/")
    public String sayHello() {
        return message;
    }
}