package com.sts.blue.app_c.tcp_client.handler;

import com.sts.blue.app_c.tcp_client.NettyClient;
import com.sts.blue.base_module.base.msg_v2.Message;
import com.sts.blue.base_module.base.msg_v2.MessageHead;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoop;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class IdleClientHandler extends SimpleChannelInboundHandler<Message> {
	public Logger log = Logger.getLogger(this.getClass());

	private NettyClient nettyClient;
	private int heartbeatCount = 0;

	/**
	 * @param nettyClient
	 */
	public IdleClientHandler(NettyClient nettyClient) {
		this.nettyClient = nettyClient;
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent event = (IdleStateEvent) evt;
			String type = "";
			if (event.state() == IdleState.READER_IDLE) {
				type = "read idle";
			} else if (event.state() == IdleState.WRITER_IDLE) {
				type = "write idle";
			} else if (event.state() == IdleState.ALL_IDLE) {
				type = "all idle";
			}
			log.debug(ctx.channel().remoteAddress() + "超时类型：" + type);
			sendPingMsg(ctx);
		} else {
			super.userEventTriggered(ctx, evt);
		}
	}

	/**
	 * 发送ping消息
	 * @param context
	 */
	protected void sendPingMsg(ChannelHandlerContext context) {

		byte[] msg = "ping".getBytes();

		MessageHead messageHead = new MessageHead();
		messageHead.setCreateDate(new Date());
		messageHead.setLength(msg.length);
		Message msgH = new Message(messageHead, msg);
		msgH.getHead().setToken(msgH.buildToken());
		msgH.getHead().setActionKey("670b14728ad9902aecba32e22fa4f6bd");
		context.writeAndFlush(msgH);
		heartbeatCount++;
//		log.info("Client sent ping msg to " + context.channel().remoteAddress() + ", count: " + heartbeatCount);
	}

	/**
	 * 处理断开重连
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		final EventLoop eventLoop = ctx.channel().eventLoop();  
		eventLoop.schedule(() -> nettyClient.doConnect(new Bootstrap(), eventLoop), 10L, TimeUnit.SECONDS);  
		super.channelInactive(ctx);  
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Message msg){
		ctx.fireChannelRead(msg);
	}
}
