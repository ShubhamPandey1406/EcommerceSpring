package com.pm.ecommerceapiintegration;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApiIntegrationApplication {

    public static void main(String[] args) {

        //load the enviroment variables
        Dotenv dotenv = Dotenv.configure().load();

        // get the enviornment variables
        dotenv.entries().forEach(entry->System.setProperty(entry.getKey(), entry.getValue()));

        SpringApplication.run(EcommerceApiIntegrationApplication.class, args);
    }

}
