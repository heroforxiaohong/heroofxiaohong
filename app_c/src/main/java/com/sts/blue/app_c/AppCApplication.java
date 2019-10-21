package com.sts.blue.app_c;

import com.sts.blue.app_c.tcp_client.NettyClient;
import com.sts.blue.app_c.webSocket_server.websocket.NioWebSocketServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppCApplication{


    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppCApplication.class, args);



        new Thread(new Runnable() {
            @Override
            public void run() {
                NettyClient client = new NettyClient();
                try {
                    client.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new NioWebSocketServer().init();


    }


}
