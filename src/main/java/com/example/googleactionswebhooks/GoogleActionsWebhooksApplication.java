package com.example.googleactionswebhooks;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GoogleActionsWebhooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoogleActionsWebhooksApplication.class, args);
    }

//    @Bean
//    public ObjectMapper objectMapper(){
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
//        mapper.setDefaultPrettyPrinter(new DefaultPrettyPrinter());
//        return mapper;
//    }

}
