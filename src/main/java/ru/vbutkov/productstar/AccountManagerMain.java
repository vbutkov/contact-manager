package ru.vbutkov.productstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AccountManagerMain {
    public static void main(String[] args) {

        var context = SpringApplication.run(AccountManagerMain.class, args);
    }
}

