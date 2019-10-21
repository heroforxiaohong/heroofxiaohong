package com.sts.blue.app_c.tcp_client.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sts.blue.app_c.tcp_client.BigWorkException;
import com.sts.blue.app_c.tcp_client.NettyActionContainer;
import com.sts.blue.app_c.tcp_client.NettyClientContainer;
//import com.sts.blue.base_module.base.msg.Message;
import com.sts.blue.app_c.tcp_client.RepeatWorkException;
import com.sts.blue.app_c.listener.SimpleCallBack;
import com.sts.blue.base_module.base.msg_v2.Message;
import com.sts.blue.base_module.base.msg_v2.MessageHead;
import com.sts.blue.base_module.base.msg_v2.MessageType;
import com.sts.blue.base_module.entity.Interaction.AppMRequestParam;
import io.netty.channel.Channel;

import java.util.Date;


public class NettySendUtils {

    /**
     *  向M发生服务请求
     *  返回0 正常 1：服务器忙，2 重复请求（不是重复操作，很难发生）
     * */
    public synchronized static int send(AppMRequestParam param, SimpleCallBack callBack, String tag){

        String req = JSON.toJSONString(param, SerializerFeature.WriteMapNullValue);
        Channel channel = NettyClientContainer.getInstance().getChannel();

//        String size = NettyActionContainer.getInstance().getCurrentSize() + "";

        if (channel.isOpen()){
            try {
                byte[] msg = req.getBytes();
                MessageHead messageHead = new MessageHead();
                messageHead.setCreateDate(new Date());
                messageHead.setMessageType(MessageType.DATA);
                messageHead.setLength(msg.length);
                Message msgH = new Message(messageHead, msg);
                msgH.getHead().setToken(msgH.buildToken());

                String key = NettyActionContainer.getInstance().produceAction(tag, callBack);
                msgH.getHead().setActionKey(key);
                channel.writeAndFlush(msgH);
                return 0;
            } catch (BigWorkException e) {
                e.printStackTrace();
                return 1;
            } catch (RepeatWorkException e) {
                e.printStackTrace();
                return 2;
            }
        }
        return -1;
    }

}
