package com.sts.blue.app_m.server.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.protobuf.ByteString;
import com.sts.blue.app_m.gate.CallEntryService;
import com.sts.blue.app_m.gate.CallEntryServiceImpl;
import com.sts.blue.app_m.server.ChannelRepository;
import com.sts.blue.base_module.base.msg.Message;
import com.sts.blue.base_module.entity.Interaction.AppMRequestParam;
import com.sts.blue.base_module.entity.Interaction.AppMResponseValue;
import com.sts.blue.base_module.listener.CallFunctionListener;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
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

//	@Autowired
	CallEntryService callEntryService = null;


	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg){
		log.info(this.getClass().getSimpleName()+"   msg:"+msg);

		Message paramMsg = (Message) msg;
		log.info(this.getClass().getSimpleName()+"   param:"+paramMsg.getMsg());

//		ctx.channel().writeAndFlush(new Message("Oh~YE~~~"));

		AppMRequestParam param = JSON.parseObject(paramMsg.getMsg(), AppMRequestParam.class);

		log.info("服务器端接收的param："+param.getPortType()+"   " +param.getParame());

//		ctx.channel().writeAndFlush(new Message("回调111"));

		if (callEntryService ==null){
			callEntryService = new CallEntryServiceImpl();
		}
		callEntryService.callFunction(param, new CallFunctionListener() {
			@Override
			public void onReturn(AppMResponseValue value) {
//				ctx.write(new Message("回调"));
				String req = JSON.toJSONString(value, SerializerFeature.WriteMapNullValue);
				ctx.channel().writeAndFlush(new Message(req));
			}

			@Override
			public void onException(Exception e) {

			}
		});

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
