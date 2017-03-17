package com.example;

import com.services.NotificationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;

@ComponentScan({"com.example", "com.services"})
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        MyAppConfig config = (MyAppConfig) ctx.getBean("myAppConfig");
        System.out.println(ctx.getBean("notification").toString());
        System.out.println(config.toString());
    }

    @Bean
    public EmbeddedServletContainerCustomizer customTomcat() {
        return container -> {
            ErrorPage notFoundPage = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
            container.addErrorPages(notFoundPage);

        };
    }

    //It should be into a Configuration component
    @Bean("notification")
    @Profile("development")
    public NotificationService developmentNotification() {
        return new NotificationService("development");
    }

    @Bean("notification")
    @Profile("production")
    public NotificationService productionNotification() {
        return new NotificationService("production");

    }
}
