package com.sts.blue.app_c.tcp_client.handler;


import com.alibaba.fastjson.JSON;
import com.sts.blue.app_c.tcp_client.NettyActionContainer;
import com.sts.blue.app_c.tcp_client.NettyClientContainer;
import com.sts.blue.base_module.base.msg_v2.Message;
import com.sts.blue.base_module.entity.Interaction.AppMResponseValue;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.log4j.Logger;

public class LogicClientHandler extends SimpleChannelInboundHandler<Message>{
	public Logger log = Logger.getLogger(this.getClass());

	private final static String CLIENTID = "123456789";

	// 连接成功后，向server发送消息  
	@Override  
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		log.debug("连接成功 ");
//		Message.MessageBase.Builder authMsg = Message.MessageBase.newBuilder();
//		authMsg.setClientId(CLIENTID);
//		authMsg.setCmd(Command.CommandType.AUTH);
//		authMsg.setData("This is auth data");
//
//		ctx.writeAndFlush(authMsg.build());
//		ctx.writeAndFlush(authMsg.build());

		NettyClientContainer.getInstance().setChannel(ctx.channel());

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		log.debug("连接断开 ");
		NettyClientContainer.getInstance().setChannel(null);
//		ctx.channel()
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {

		log.info(new String(msg.getContent()));

		switch (msg.getHead().getMessageType()){
			case REQ_DATA:

				AppMResponseValue value = JSON.parseObject(msg.getContent(), AppMResponseValue.class);

				NettyActionContainer.getInstance().consumeAction(msg.getHead().getActionKey(), value);

				break;
		}

//		if(msg.getCmd().equals(Command.CommandType.AUTH_BACK)){
//			log.debug("验证成功");
//			ctx.writeAndFlush(
//					Message.MessageBase.newBuilder()
////					.setClientId(CLIENTID)
//					.setCmd(Command.CommandType.PUSH_DATA)
//					.setData("This is upload data")
//					.build()
//					);
//
//		}else if(msg.getCmd().equals(Command.CommandType.PING)){
//			//接收到server发送的ping指令
//			log.info(msg.getData());
//
//		}else if(msg.getCmd().equals(Command.CommandType.PONG)){
//			//接收到server发送的pong指令
//			log.info(msg.getData());
//
//		}else if(msg.getCmd().equals(Command.CommandType.PUSH_DATA)){
//			//接收到server推送数据
//			log.info(msg.getData());
//
//		}else if(msg.getCmd().equals(Command.CommandType.PUSH_DATA_BACK)){
//			//接收到server返回数据
//			log.info(msg.getData());
//
//		}else{
//			log.info(msg.getData());
//		}
	}
}
