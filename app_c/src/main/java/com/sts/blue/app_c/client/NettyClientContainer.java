package com.sts.blue.app_c.client;

import io.netty.channel.Channel;

import java.util.*;

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
