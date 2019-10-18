package com.sts.blue.app_main;

import com.sts.blue.app_c.AppCApplication;
import com.sts.blue.app_m.AppMApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class AppMainApplication {

    public static void main(String[] args) {
//        SpringApplication.run(AppMainApplication.class, args);
        SpringApplication.run(AppCApplication.class, args);
//        SpringApplication.run(AppMApplication.class, args);
    }

}
