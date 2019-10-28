package com.sts.blue.app_c.fun_test;

import com.alibaba.fastjson.JSON;
import com.sts.blue.app_c.listener.SimpleCallBack;
import com.sts.blue.app_c.webSocket_server.global.ChannelSupervise;
import io.netty.channel.Channel;
import io.netty.channel.ChannelId;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class TestControlEntrance {

    /**
     * 登录功能的 webSocket 入口
     * */
    public void doWebSocketTest(String str, ChannelId channelId){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Channel channel = ChannelSupervise.findChannel(channelId.asShortText());
        if (null!=channel && channel.isOpen()){
            TextWebSocketFrame tws = new TextWebSocketFrame(str);
            channel.writeAndFlush(tws);
        }

    }

}
