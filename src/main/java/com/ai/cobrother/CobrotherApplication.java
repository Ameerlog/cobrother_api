package com.ai.cobrother;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class CobrotherApplication {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(CobrotherApplication.class, args);
    }

    @PostConstruct
    public void printMongoEnv() {
        String raw = System.getenv("SPRING_DATA_MONGODB_URI");
        System.out.println("SPRING_DATA_MONGODB_URI present? " + (raw != null && !raw.isBlank()));

        String prop = env.getProperty("spring.data.mongodb.uri");
        System.out.println("spring.data.mongodb.uri present? " + (prop != null && !prop.isBlank()));

        if (prop != null) {
            // mask credentials if any
            System.out.println("spring.data.mongodb.uri (masked) = " + prop.replaceAll("(?<=mongodb\\+srv://)[^@]+@", "***@"));
        }
    }
} 







// package com.ai.cobrother;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class CobrotherApplication {

//     public static void main(String[] args) {
//         SpringApplication.run(CobrotherApplication.class, args);
//     }

// }
