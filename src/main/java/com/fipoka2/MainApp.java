package com.fipoka2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Дима on 28.04.2017.
 */
@EnableTransactionManagement
@SpringBootApplication
public class MainApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(MainApp.class,args);
    }
}
