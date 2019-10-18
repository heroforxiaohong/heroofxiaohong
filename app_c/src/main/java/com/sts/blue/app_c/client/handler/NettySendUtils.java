package com.sts.blue.app_c.client.handler;

import com.sts.blue.app_c.client.NettyClientContainer;
import com.sts.blue.base_module.base.common.protobuf.Command;
import com.sts.blue.base_module.base.common.protobuf.Message;
import io.netty.channel.Channel;


public class NettySendUtils {
    private static int index = 1;
    public synchronized static boolean send(){

        Channel channel = NettyClientContainer.getInstance().getChannel();

        if (channel.isOpen()){
            Message.MessageBase.Builder authMsg = Message.MessageBase.newBuilder();
            authMsg.setClientId("123456789");
            authMsg.setCmd(Command.CommandType.AUTH);
            authMsg.setData("This is auth data 991TT " + (index++));

            channel.writeAndFlush(authMsg.build());
        }
        return false;
    }

}
