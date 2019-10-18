package com.sts.blue.app_c;

import com.sts.blue.app_c.client.NettyClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppCApplication{


    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppCApplication.class, args);

        NettyClient client = new NettyClient();
        client.run();
    }


}
