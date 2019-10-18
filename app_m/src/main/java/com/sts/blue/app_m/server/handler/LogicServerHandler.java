package com.sts.blue.app_m.server.handler;

import com.sts.blue.app_m.server.ChannelRepository;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 业务逻辑handler
 * @author Ke Shanqiang
 *
 */
@Component
@Qualifier("logicServerHandler")
@ChannelHandler.Sharable
public class LogicServerHandler extends ChannelInboundHandlerAdapter{
	public Logger log = Logger.getLogger(this.getClass());
	private final AttributeKey<String> clientInfo = AttributeKey.valueOf("clientInfo");

	@Autowired
	@Qualifier("channelRepository")
	ChannelRepository channelRepository;

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		log.info(this.getClass().getSimpleName()+"   msg:"+msg);

		ByteBuf buf=(ByteBuf) msg;
		byte[] req=new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body=new String(req,"UTF-8");
		log.info("服务器端接收的消息："+body);
		try{
//			//这个analysis是处理部分 返回String类型
//			String dispose = analysis(body);
//			log.info("服务器返回的消息："+dispose);
//			ByteBuf resp= Unpooled.copiedBuffer(dispose.getBytes());
//			//返回给客户端
//			ctx.write(resp);
		}catch (Exception e){
//			Errorr errorr = new Errorr();
//			errorr.setType("500");
//			try{
//				//截取异常
//				errorr.setResult(e.toString().split(":")[1]);
//			}catch (Exception e2){
//				errorr.setResult("请联系管理员处理！");
//			}
//			String dispose = JSON.toJSONString(errorr);
//			log.info("服务器返回的消息："+dispose);
//			ByteBuf resp= Unpooled.copiedBuffer(dispose.getBytes());
//			ctx.write(resp);
		}

//		Message.MessageBase msgBase = (Message.MessageBase)msg;
//
//		log.info(msgBase.getData());
//
//		ChannelFuture cf = ctx.writeAndFlush(
//				MessageBase.newBuilder()
//				.setClientId(msgBase.getClientId())
//				.setCmd(CommandType.UPLOAD_DATA_BACK)
//				.setData("This is upload data back msg")
//				.build()
//				);
//		/* 上一条消息发送成功后，立马推送一条消息 */
//		cf.addListener(new GenericFutureListener<Future<? super Void>>() {
//			@Override
//			public void operationComplete(Future<? super Void> future) throws Exception {
//				if (future.isSuccess()){
//					ctx.writeAndFlush(
//							MessageBase.newBuilder()
//							.setClientId(msgBase.getClientId())
//							.setCmd(CommandType.PUSH_DATA)
//							.setData("This is a push msg")
//							.build()
//							);
//				}
//			}
//		});
//		ReferenceCountUtil.release(msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

	}

	@SuppressWarnings("deprecation")
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		Attribute<String> attr = ctx.attr(clientInfo);
		String clientId = attr.get();
		log.error("Connection closed, client is " + clientId);
		cause.printStackTrace();
	}
}
