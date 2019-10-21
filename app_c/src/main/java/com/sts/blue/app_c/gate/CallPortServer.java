package com.sts.blue.app_c.gate;


import io.netty.channel.ChannelId;

public interface CallPortServer {

    void doPort(String param, ChannelId clientID);

}
