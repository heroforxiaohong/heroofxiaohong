package com.sts.blue.app_c.webSocket_server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelId;

import java.util.HashMap;

public class WebSocketChannelContainer {

    private static WebSocketChannelContainer instance = new WebSocketChannelContainer();

    public static WebSocketChannelContainer getInstance(){
        return instance;
    }

    int max = 5; // 后期需修改为安装权限配置链接数
    private HashMap<ChannelId, Channel> map = new HashMap<>(10);

    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public void saveChannel(Channel channel) throws MoreWebSocketException {
        if (map.size() >= max){
            throw new MoreWebSocketException("链接数过多");
        }

        map.put(channel.id(), channel);
    }

    public Channel getChannel(ChannelId id){
        if (map.containsKey(id)){
            return map.get(id);
        }

        return null;
    }

    public void removeChannel(ChannelId id){
        if (map.containsKey(id)){
            map.remove(id);
        }
    }

}
