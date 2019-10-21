package com.sts.blue.app_m.server.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sts.blue.app_m.gate.CallEntryService;
import com.sts.blue.app_m.gate.CallEntryServiceImpl;
import com.sts.blue.app_m.server.ChannelRepository;
import com.sts.blue.base_module.base.msg_v2.Message;
import com.sts.blue.base_module.base.msg_v2.MessageHead;
import com.sts.blue.base_module.base.msg_v2.MessageType;
import com.sts.blue.base_module.entity.Interaction.AppMRequestParam;
import com.sts.blue.base_module.entity.Interaction.AppMResponseValue;
import com.sts.blue.base_module.listener.CallFunctionListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.ReferenceCountUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;

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

	@Autowired
	@Qualifier("channelRepository")
	ChannelRepository channelRepository;


//	@Autowired
	CallEntryService callEntryService = null; // M 模块功能入口实体


	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg){
		Message paramMsg = (Message) msg;

		log.info("---  " + new String(paramMsg.getContent()));

		switch (paramMsg.getHead().getMessageType()){
			case DATA:
				dataProcessing(ctx, paramMsg);
				break;
			case PING:
				// ping消息用于 客户机获取服务机状态，可返回pong数据，或丢弃
				break;
		}
		ReferenceCountUtil.release(msg);//清除数据流缓存
	}

	/**
	 * 客户机发来请求的处理方法
	 * */
	private void dataProcessing(ChannelHandlerContext ctx, Message paramMsg){
		AppMRequestParam param = JSON.parseObject(new String(paramMsg.getContent()), AppMRequestParam.class);
		if (callEntryService ==null){
			callEntryService = new CallEntryServiceImpl();
		}
		callEntryService.callFunction(param, new CallFunctionListener() {
			@Override
			public void onReturn(AppMResponseValue value) { //功能处理的正常回调
				String req = JSON.toJSONString(value, SerializerFeature.WriteMapNullValue);
				byte[] msg = req.getBytes();
				MessageHead messageHead = new MessageHead();
				messageHead.setCreateDate(new Date());
				messageHead.setMessageType(MessageType.REQ_DATA);
				messageHead.setLength(msg.length);
				Message msgH = new Message(messageHead, msg);
				msgH.getHead().setToken(msgH.buildToken());
				msgH.getHead().setActionKey(paramMsg.getHead().getActionKey());
				ctx.channel().writeAndFlush(msgH);
			}

			@Override
			public void onException(Exception e) { // 异常回调

			}
		});
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

	}

	@SuppressWarnings("deprecation")
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		log.error("Connection closed one");
		cause.printStackTrace();
	}
}
