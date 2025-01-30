package com.meta.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public MyFirstClass huhuha(){
        return new MyFirstClass("buhahah");
    }
}
