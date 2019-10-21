package com.sts.blue.app_c.tcp_client;

import io.netty.channel.Channel;

public class NettyClientContainer {

    private static NettyClientContainer instance = new NettyClientContainer();

    public static NettyClientContainer getInstance(){
        return instance;
    }

//    private final int max = 1;

    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
