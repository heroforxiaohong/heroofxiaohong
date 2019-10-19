package com.sts.blue.app_c.client.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sts.blue.app_c.client.NettyClientContainer;
import com.sts.blue.base_module.base.msg.Message;
import com.sts.blue.base_module.entity.Interaction.AppMRequestParam;
import com.sts.blue.base_module.static_value.M_ServiceType;
import io.netty.channel.Channel;


public class NettySendUtils {

    /**
     *
     * */
    public synchronized static boolean send(AppMRequestParam param){

        String req = JSON.toJSONString(param, SerializerFeature.WriteMapNullValue);
        Channel channel = NettyClientContainer.getInstance().getChannel();

        if (channel.isOpen()){
//            Message.MessageBase.Builder authMsg = Message.MessageBase.newBuilder();
//            authMsg.setClientId(clientID);
//            authMsg.setCmd(Command.CommandType.AUTH);
//            authMsg.setData(req);

            channel.writeAndFlush(new Message(req));
        }
        return false;
    }

}
