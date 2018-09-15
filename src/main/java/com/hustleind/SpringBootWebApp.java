package com.hustleind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com.hustleind"} , exclude = JpaRepositoriesAutoConfiguration.class)
public class SpringBootWebApp extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWebApp.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootWebApp.class, args);
    }
}
