package com.ai.cobrother;

import com.ai.cobrother.Model.User;
import com.ai.cobrother.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class  CobrotherApplication {

    public static void main(String[] args) {
        SpringApplication.run(CobrotherApplication.class, args);


//        System.out.println("ENV = " + System.getenv("LINKEDIN_CLIENT_ID"));
    }


    @Bean
    CommandLineRunner test(UserRepository repo){
        return args -> {
            User u = new User();
            u.setUsername("demoUser");
            u.setPassword("123456");
            repo.save(u);
        };
    }

    @Bean
    CommandLineRunner checkDB(org.springframework.data.mongodb.core.MongoTemplate template){
        return args -> {
            System.out.println("Connected DB: " + template.getDb().getName());
        };
    }

}
